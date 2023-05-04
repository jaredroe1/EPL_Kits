package com.promineotech.eplkits.dao;

import java.util.Optional;

import com.promineotech.eplkits.entity.Jerseys;
import com.promineotech.eplkits.entity.Orders;
import com.promineotech.eplkits.entity.Shoes;
import com.promineotech.eplkits.entity.Shorts;
import com.promineotech.eplkits.entity.Teams;
import com.promineotech.eplkits.entity.Trainers;
import com.promineotech.eplkits.entity.Users;

public interface EPLKitsOrderDao {

	Orders saveOrder(Users users, Teams teams, Shoes shoes, Jerseys jerseys,
			Shorts shorts, Trainers trainers);

	Optional<Trainers> fetchTrainers(String trainersId);

	Optional<Shorts> fetchShorts(String shortsId);

	Optional<Jerseys> fetchJerseys(String jerseysId);

	Optional<Shoes> fetchShoes(String shoesId);

	Optional<Teams> fetchTeams(String teamsId);

	Optional<Users> fetchUsers(String usersId);

	Orders updateKit(Long ordersPK, Users users, Teams teams, Shoes shoes, Jerseys jerseys, Shorts shorts,
			Trainers trainers);

	Orders deleteKit(Long ordersPK);

	

}
