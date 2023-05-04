package com.promineotech.eplkits.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Shorts {
	private Long shortsPK;
	private String shortsId;
	private BigDecimal price;
	
	@JsonIgnore
	public Long getShortsPK() {
		return shortsPK;
	}

}
