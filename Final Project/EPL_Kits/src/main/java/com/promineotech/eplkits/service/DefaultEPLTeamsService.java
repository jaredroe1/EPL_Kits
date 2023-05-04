package com.promineotech.eplkits.service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.eplkits.dao.EPLTeamsDao;
import com.promineotech.eplkits.entity.Names;
import com.promineotech.eplkits.entity.Numbers;
import com.promineotech.eplkits.entity.Shoes;
import com.promineotech.eplkits.entity.Teams;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultEPLTeamsService implements EPLTeamsService {
	
	@Autowired
	private EPLTeamsDao eplTeamsDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<Teams> fetchTeams(String teamsCountry) {
		log.info("The fetchTeams method was called with country={}",
				teamsCountry);
		List<Teams> teams = eplTeamsDao.fetchTeams(teamsCountry);
		
		if(teams.isEmpty()) {
			String msg = String.format("No teams found with country=%s", teamsCountry);
			throw new NoSuchElementException(msg);
		}
				
		return teams;
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Shoes> fetchShoes(String shoesType) {
		log.info("The fetchShoes method was call with shoes={}", shoesType);
		
		List<Shoes> shoes = eplTeamsDao.fetchShoes(shoesType);
		
		if(shoes.isEmpty()) {
			String msg = String.format("No shoes found with id=%s", shoesType);
			throw new NoSuchElementException(msg);
		}
		
		return shoes;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Names> fetchNames(String namesLeague) {
		log.info("The fetchNames method was called with id=%s", namesLeague);
		
		List<Names> names = eplTeamsDao.fetchNames(namesLeague);
		
		if(names.isEmpty()) {
			String msg = String.format("No names found with id=%s", namesLeague);
			throw new NoSuchElementException(msg);
		}
		return names;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Numbers> fetchNumbers(String numbersPosition) {
		log.info("The fetchNumbers method was called with id=%s", numbersPosition);
		
		List<Numbers> numbers = eplTeamsDao.fetchNumbers(numbersPosition);
		
		if(numbers.isEmpty()) {
			String msg = String.format("No numbers found with id=%s", numbersPosition);
			throw new NoSuchElementException(msg);
		}
		return numbers;
	}

}
