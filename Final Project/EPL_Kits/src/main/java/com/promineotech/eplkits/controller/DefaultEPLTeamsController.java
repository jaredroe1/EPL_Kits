package com.promineotech.eplkits.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.eplkits.entity.Names;
import com.promineotech.eplkits.entity.Numbers;
import com.promineotech.eplkits.entity.Shoes;
import com.promineotech.eplkits.entity.Teams;
import com.promineotech.eplkits.service.EPLTeamsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultEPLTeamsController implements EPLTeamsController {
	
	@Autowired
	private EPLTeamsService eplTeamsService;

	@Override
	public List<Teams> fetchTeams(String teamsCountry) {
		log.debug("teams={}", teamsCountry);
		return eplTeamsService.fetchTeams(teamsCountry);
	}

	@Override
	public List<Shoes> fetchShoes(String shoesType) {
		log.debug("shoes={}", shoesType);
		return eplTeamsService.fetchShoes(shoesType);
	}

	@Override
	public List<Names> fetchNames(String namesLeague) {
		log.debug("names={}", namesLeague);
		return eplTeamsService.fetchNames(namesLeague);
	}

	@Override
	public List<Numbers> fetchNumbers(String numbersPosition) {
		log.debug("numbers={}", numbersPosition);
		return eplTeamsService.fetchNumbers(numbersPosition);
	}

	

}
