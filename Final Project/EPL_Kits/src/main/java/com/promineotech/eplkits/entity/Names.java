package com.promineotech.eplkits.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Names {
	private Long namesPK;
	private String namesLeague;
	private String namesId;
	private BigDecimal price;
	
	@JsonIgnore
	public Long getNamesPK() {
		return namesPK;
	}

}
