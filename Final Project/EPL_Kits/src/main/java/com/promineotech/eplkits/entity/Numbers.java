package com.promineotech.eplkits.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Numbers {
	private Long numbersPK;
	private String numbersPosition;
	private int numbersId;
	private BigDecimal price;
	
	@JsonIgnore
	public Long getNumbersPK() {
		return numbersPK;
	}

}
