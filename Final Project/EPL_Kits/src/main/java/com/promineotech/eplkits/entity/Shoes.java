package com.promineotech.eplkits.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Shoes {
	private Long shoesPK;
	private String shoesType;
	private String shoesId;
	private BigDecimal price;
	
	@JsonIgnore
	public Long getShoesPK() {
		return shoesPK;
	}

}
