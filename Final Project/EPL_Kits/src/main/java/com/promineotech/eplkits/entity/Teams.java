package com.promineotech.eplkits.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Teams {
	private Long teamsPK;
	private String teamsId;
	private String teamsCountry;
	
	@JsonIgnore
	public Long getTeamsPK() {
		return teamsPK;
	}
}
