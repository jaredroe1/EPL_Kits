package com.promineotech.eplkits.dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.promineotech.eplkits.entity.Jerseys;
import com.promineotech.eplkits.entity.Orders;
import com.promineotech.eplkits.entity.Shoes;
import com.promineotech.eplkits.entity.Shorts;
import com.promineotech.eplkits.entity.Teams;
import com.promineotech.eplkits.entity.Trainers;
import com.promineotech.eplkits.entity.Users;

@Component
public class DefaultEPLKitsOrderDao implements EPLKitsOrderDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public Orders saveOrder(Users users, Teams teams, Shoes shoes, Jerseys jerseys, Shorts shorts, Trainers trainers) {
		SqlParams params = 
				generateInsertSql(users, teams, shoes, jerseys, shorts, trainers);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(params.sql,  params.source, keyHolder);
		
		Long orderPK = keyHolder.getKey().longValue();
		// @formatter:off
		return Orders.builder()
				.ordersPK(orderPK)
				.users(users)
				.teams(teams)
				.shoes(shoes)
				.jerseys(jerseys)
				.shorts(shorts)
				.trainers(trainers)				
				.build();
		// @formatter:on
	}
	
	
	@Override
	public Orders updateKit(Long ordersPK, Users users, Teams teams, Shoes shoes, Jerseys jerseys, Shorts shorts,
			Trainers trainers) {
		
		SqlParams sqlParams = generateUpdateSql(ordersPK, users, teams, shoes, jerseys, shorts, trainers);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(sqlParams.sql, sqlParams.source, keyHolder);		
		
		
		return Orders.builder()
				.ordersPK(ordersPK)
				.users(users)
				.teams(teams)
				.shoes(shoes)
				.jerseys(jerseys)
				.shorts(shorts)
				.trainers(trainers)				
				.build();
	}
	
	@Override
	public Orders deleteKit(Long ordersPK) {
		SqlParams sqlParams = new SqlParams();
				
		String sql = "DELETE FROM orders WHERE orders_pk = :orders_pk";
		sqlParams.source.addValue("orders_pk", ordersPK);
		
		jdbcTemplate.update(sql,  sqlParams.source);
		
		return Orders.builder().ordersPK(ordersPK).build();
	}
	
	private SqlParams generateInsertSql(Users users, Teams teams, Shoes shoes, Jerseys jerseys, Shorts shorts,
			Trainers trainers) {
		
		// @formatter:off
		String sql = ""
				+ "INSERT INTO orders ("
				+ "users_fk, teams_fk, shoes_fk, jerseys_fk, shorts_fk, trainers_fk"
				+ ") VALUES ("
				+ ":users_fk, :teams_fk, :shoes_fk, :jerseys_fk, :shorts_fk, :trainers_fk"
				+ ")";
		// @formatter:on
		
		SqlParams params = new SqlParams();
		
		params.sql = sql;
		params.source.addValue("users_fk",users.getUsersId());
		params.source.addValue("teams_fk", teams.getTeamsId());
		params.source.addValue("shoes_fk", shoes.getShoesId());
		params.source.addValue("jerseys_fk", jerseys.getJerseysId());
		params.source.addValue("shorts_fk", shorts.getShortsId());
		params.source.addValue("trainers_fk", trainers.getTrainersId());		
		
		return params;
	}
	
	private SqlParams generateUpdateSql(Long ordersPK, Users users, Teams teams, Shoes shoes, Jerseys jerseys,
			Shorts shorts, Trainers trainers) {
		
		// @formatter:off
				String sql = ""
						+ "UPDATE orders "
						+ "SET users_fk = :users_fk, teams_fk = :teams_fk, shoes_fk = :shoes_fk, jerseys_fk = :jerseys_fk, shorts_fk = :shorts_fk, "
						+ "trainers_fk = :trainers_fk "
						+ "WHERE orders_pk = :orders_pk";						
				// @formatter:on
				
				SqlParams params = new SqlParams();
				
				params.sql = sql;
				params.source.addValue("orders_pk", ordersPK);
				params.source.addValue("users_fk",users.getUsersId());
				params.source.addValue("teams_fk", teams.getTeamsId());
				params.source.addValue("shoes_fk", shoes.getShoesId());
				params.source.addValue("jerseys_fk", jerseys.getJerseysId());
				params.source.addValue("shorts_fk", shorts.getShortsId());
				params.source.addValue("trainers_fk", trainers.getTrainersId());
				
		
		return params;
	}
	
	class SqlParams {
	    String sql;
	    MapSqlParameterSource source = new MapSqlParameterSource();
	  }
	

	@Override
	public Optional<Trainers> fetchTrainers(String trainersId) {
		String sql = ""
				+ "SELECT * "
				+ "FROM trainers "
				+ "WHERE trainers_id = :trainers_id";
		
		Map<String, Object> params = new HashMap<>();
		params.put("trainers_id", trainersId);
		
		return Optional.ofNullable(jdbcTemplate.query(sql,  params, new TrainersResultExtractor()));
	}

	@Override
	public Optional<Shorts> fetchShorts(String shortsId) {
		String sql = ""
				+ "SELECT * "
				+ "FROM shorts "
				+ "WHERE shorts_id = :shorts_id";
		
		Map<String, Object> params = new HashMap<>();
		params.put("shorts_id", shortsId);
		
		return Optional.ofNullable(jdbcTemplate.query(sql,  params, new ShortsResultExtractor()));
	}

	@Override
	public Optional<Jerseys> fetchJerseys(String jerseysId) {
		String sql = ""
				+ "SELECT * "
				+ "FROM jerseys "
				+ "WHERE jerseys_id = :jerseys_id";
		
		Map<String, Object> params = new HashMap<>();
		params.put("jerseys_id", jerseysId);
		
		return Optional.ofNullable(jdbcTemplate.query(sql,  params, new JerseyResultExtractor()));
	}

	@Override
	public Optional<Shoes> fetchShoes(String shoesId) {
		String sql = ""
				+ "SELECT * "
				+ "FROM shoes "
				+ "WHERE shoes_id = :shoes_id";
		
		Map<String, Object> params = new HashMap<>();
		params.put("shoes_id", shoesId);
		
		return Optional.ofNullable(jdbcTemplate.query(sql,  params, new ShoesResultExtractor()));
	}

	@Override
	public Optional<Teams> fetchTeams(String teamsId) {
		String sql = ""
				+ "SELECT * "
				+ "FROM teams "
				+ "WHERE teams_id = :teams_id";
		
		Map<String, Object> params = new HashMap<>();
		params.put("teams_id", teamsId);
		
		return Optional.ofNullable(jdbcTemplate.query(sql,  params, new TeamResultExtractor()));
	}

	@Override
	public Optional<Users> fetchUsers(String usersId) {
		String sql = ""
				+ "SELECT * "
				+ "FROM users "
				+ "WHERE users_id = :users_id";
		
		Map<String, Object> params = new HashMap<>();
		params.put("users_id", usersId);
		
		return Optional.ofNullable(jdbcTemplate.query(sql,  params, new UsersResultExtractor()));
	}
	
	class TrainersResultExtractor implements ResultSetExtractor<Trainers> {
		@Override
		public Trainers extractData(ResultSet rs) throws SQLException {
			rs.next();
		
		// @formatter:off
		return Trainers.builder()
				.trainersPK(rs.getLong("trainers_pk"))
				.trainersId(rs.getString("trainers_id"))
				.build();
		}
	}
	
	class ShortsResultExtractor implements ResultSetExtractor<Shorts> {
		@Override
		public Shorts extractData(ResultSet rs) throws SQLException {
			rs.next();
		
		// @formatter:off
		return Shorts.builder()
				.shortsPK(rs.getLong("shorts_pk"))
				.shortsId(rs.getString("shorts_id"))
				.build();
		}
	}

	class JerseyResultExtractor implements ResultSetExtractor<Jerseys> {
		@Override
		public Jerseys extractData(ResultSet rs) throws SQLException {
			rs.next();
		
		// @formatter:off
		return Jerseys.builder()
				.jerseysPK(rs.getLong("jerseys_pk"))
				.jerseysId(rs.getString("jerseys_id"))
				.build();
		}
	}

	class ShoesResultExtractor implements ResultSetExtractor<Shoes> {
		@Override
		public Shoes extractData(ResultSet rs) throws SQLException {
			rs.next();
		
		// @formatter:off
		return Shoes.builder()
				.shoesPK(rs.getLong("shoes_pk"))
				.shoesId(rs.getString("shoes_id"))
				.build();
		}
	}
	
	class TeamResultExtractor implements ResultSetExtractor<Teams> {
		@Override
		public Teams extractData(ResultSet rs) throws SQLException {
			rs.next();
		
		// @formatter:off
		return Teams.builder()
				.teamsPK(rs.getLong("teams_pk"))
				.teamsId(rs.getString("teams_id"))
				.build();
		}
	}
	
	class UsersResultExtractor implements ResultSetExtractor<Users> {
		@Override
		public Users extractData(ResultSet rs) throws SQLException {
			rs.next();
		
		// @formatter:off
		return Users.builder()
				.usersPK(rs.getLong("users_pk"))
				.usersId(rs.getString("users_id"))
				.firstName(rs.getString("first_name"))
				.lastName(rs.getString("last_name"))
				.phone(rs.getString("phone"))
				.build();
		}
	}

}

