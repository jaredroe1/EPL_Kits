package com.promineotech.eplkits.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Users {
	private Long usersPK;
	private String usersId;
	private String firstName;
	private String lastName;
	private String phone;
	
	@JsonIgnore
	public Long getUsersPK() {
		return usersPK;
	}
}
