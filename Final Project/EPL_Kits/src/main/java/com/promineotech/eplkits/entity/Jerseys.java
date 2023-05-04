package com.promineotech.eplkits.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Jerseys {
	private Long jerseysPK;
	private String jerseysId;
	private Numbers number;
	private Names name;
	private BigDecimal price;
	
	@JsonIgnore
	public Long getJerseysPK() {
		return jerseysPK;
	}

}
