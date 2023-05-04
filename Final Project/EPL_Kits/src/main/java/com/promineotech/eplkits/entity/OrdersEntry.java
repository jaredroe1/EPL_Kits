package com.promineotech.eplkits.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class OrdersEntry {
	
	
	@NotNull
	@Length(max = 30)
	@Pattern (regexp = "[\\w\\s]*")
	private String trainers;
	
	@NotNull
	@Length(max = 30)
	@Pattern (regexp = "[\\w\\s]*")
	private String shorts;
	
	@NotNull
	@Length(max = 30)
	@Pattern (regexp = "[\\w\\s]*")
	private String jerseys;
	
	@NotNull
	@Length(max = 30)
	@Pattern (regexp = "[\\w\\s]*")
	private String shoes;
	
	@NotNull
	@Length(max = 30)
	@Pattern (regexp = "[\\w\\s]*")
	private String teams;
	
	@NotNull
	@Length(max = 30)
	@Pattern (regexp = "[\\w\\s]*")
	private String users;
	
	

}
