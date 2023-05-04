package com.promineotech.eplkits.service;

import java.util.List;

import com.promineotech.eplkits.entity.Names;
import com.promineotech.eplkits.entity.Numbers;
import com.promineotech.eplkits.entity.Shoes;
import com.promineotech.eplkits.entity.Teams;

public interface EPLTeamsService {
	
	List<Teams> fetchTeams(String teamsCountry);
	
	List<Shoes> fetchShoes(String shoesId);
	
	List<Names> fetchNames(String namesId);
	
	List<Numbers> fetchNumbers (String numbersId);

}
