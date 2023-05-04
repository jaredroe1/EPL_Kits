package com.promineotech.eplkits.dao;

import java.util.List;

import com.promineotech.eplkits.entity.Names;
import com.promineotech.eplkits.entity.Numbers;
import com.promineotech.eplkits.entity.Shoes;
import com.promineotech.eplkits.entity.Teams;

public interface EPLTeamsDao {
	
	List<Teams> fetchTeams(String teamsCountry);
	
	List<Shoes> fetchShoes(String shoesType);
	
	List<Names> fetchNames(String namesLeague);
	
	List<Numbers> fetchNumbers (String numbersPosition);

}
