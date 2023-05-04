package com.promineotech.eplkits.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.promineotech.eplkits.entity.Names;
import com.promineotech.eplkits.entity.Numbers;
import com.promineotech.eplkits.entity.Shoes;
import com.promineotech.eplkits.entity.Teams;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class DefaultEPLTeamsDao implements EPLTeamsDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Teams> fetchTeams(String teamsCountry) {
		log.info("DAO: teams_country={}", teamsCountry);
		
		// @formatter:off
		String sql = ""
				+ "SELECT * "
				+ "FROM teams "
				+ "WHERE teams_country = :teams_country";
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("teams_country", teamsCountry);
		
		return jdbcTemplate.query(sql,  params,
				new RowMapper<>() {
				@Override
				public Teams mapRow(ResultSet rs, int rowNum) throws SQLException {
				return Teams.builder()
						.teamsPK(rs.getLong("teams_pk"))
						.teamsCountry(rs.getString("teams_country"))
						.teamsId(rs.getString("teams_id"))						
						.build();
		}}
				);
	}

	@Override
	public List<Shoes> fetchShoes(String shoesType) {
		log.info("DAO: shoes={}", shoesType);
		
		// @formatter:off
		String sql = ""
				+ "SELECT * "
				+ "FROM shoes";				
		// @formatter:on
		
		Map<String, Object> params = Map.of("shoes_id", shoesType);	
		
		return jdbcTemplate.query(sql,  params,
				new RowMapper<>() {
				@Override
				public Shoes mapRow(ResultSet rs, int rowNum) throws SQLException {
				return Shoes.builder()
						.shoesPK(rs.getLong("shoes_pk"))
						.shoesType(rs.getString("shoes_type"))
						.shoesId(rs.getString("shoes_id"))
						.price(rs.getBigDecimal("price"))
						.build();	
				}
		});
			
		
	}

	@Override
	public List<Names> fetchNames(String namesLeague) {
		log.info("DAO: names={}", namesLeague);
		
		// @formatter:off
		String sql = ""
				+ "SELECT * "
				+ "FROM names";				
		// @formatter:on
		
		Map<String, Object> params = Map.of("names_id", namesLeague);
		
		return jdbcTemplate.query(sql,  params,
				new RowMapper<>() {
				@Override
				public Names mapRow(ResultSet rs, int rowNum) throws SQLException {
				return Names.builder()
						.namesPK(rs.getLong("names_pk"))
						.namesLeague(rs.getString("names_league"))
						.namesId(rs.getString("names_id"))
						.price(rs.getBigDecimal("price"))
						.build();
			}
		});
	}

	@Override
	public List<Numbers> fetchNumbers(String numbersPosition) {
		log.info("DAO: numbers={}", numbersPosition);
		
		// @formatter:off
		String sql = ""
				+ "SELECT * "
				+ "FROM numbers";
		// @formatter:on
		
		Map<String, Object> params = Map.of("numbers_id", numbersPosition);
		
		return jdbcTemplate.query(sql,  params,
				new RowMapper<>() {
				@Override
				public Numbers mapRow(ResultSet rs, int rowNum) throws SQLException {
				return Numbers.builder()
						.numbersPK(rs.getLong("numbers_pk"))
						.numbersPosition(rs.getString("numbers_position"))
						.numbersId(rs.getInt("numbers_id"))
						.price(rs.getBigDecimal("price"))
						.build();	
				}
		});
	}

}
