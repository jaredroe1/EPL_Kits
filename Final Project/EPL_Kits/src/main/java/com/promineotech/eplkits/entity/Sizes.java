package com.promineotech.eplkits.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Sizes {
	private Long sizesPK;
	private String sizesId;
	private BigDecimal price;
	
	@JsonIgnore
	public Long getSizesPK() {
		return sizesPK;
	}

}
