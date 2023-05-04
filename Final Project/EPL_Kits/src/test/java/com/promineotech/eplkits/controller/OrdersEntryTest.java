package com.promineotech.eplkits.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import com.promineotech.eplkits.entity.Orders;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(
		  scripts = {"classpath:flyway/migrations/V1.0__EPL_Kits.sql",
				  "classpath:flyway/migrations/V1.0__EPL_Kits_Data.sql"},
		  config = @SqlConfig(encoding = "utf-8"))
public class OrdersEntryTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int serverPort;
	
	@Test
	void testCreateOrderReturnsSuccess201() {
		// Given an order as JSON and uri
		String body = createOrderBody();
		String uri = String.format("http://localhost:%d/orders", serverPort);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> bodyEntity = new HttpEntity<>(body, headers);
		
		// When the order is sent
		ResponseEntity<Orders> response = restTemplate.exchange(uri,
				HttpMethod.POST, bodyEntity, Orders.class);
		
		// Then a 201 status is returned
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
	}
	
	private String createOrderBody() {
		// @formatter:off
		return "{\n"
				+ "  \"trainers\":\"Home_trainers\",\n"
				+ "  \"shorts\":\"Home_shorts\",\n"
				+ "  \"jerseys\":\"Home_jersey\",\n"
				+ "  \"shoes\":\"Nike Tiempo Legend 9 Elite\",\n"
				+ "  \"teams\":\"Tottenham\",\n"
				+ "  \"users\":\"JARED_ROE\"\n"
				+ "}";
	}

}
