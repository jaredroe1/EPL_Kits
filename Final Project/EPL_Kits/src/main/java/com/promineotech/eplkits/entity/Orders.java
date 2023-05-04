package com.promineotech.eplkits.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Orders {
	private Long ordersPK;
	private Users users;
	private Teams teams;
	private Shoes shoes;
	private Jerseys jerseys;
	private Shorts shorts;
	private Trainers trainers;	
	
	
	
	@JsonIgnore
	public Long getOrdersPK() {
		return ordersPK;
	}

}
