package com.promineotech.eplkits.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import com.promineotech.eplkits.entity.Teams;

@Nested
 @SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
 @ActiveProfiles("test")
 @Sql(
	  scripts = {"classpath:flyway/migrations/V1.0__EPL_Kits.sql",
			  "classpath:flyway/migrations/V1.0__EPL_Kits_Data.sql"},
	  config = @SqlConfig(encoding = "utf-8"))
 class FetchTeamsTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int serverPort;
	
	@Test
	void testThatTeamsAreReturnedWhenAValidCountryNameIsSupplied() {
		// Given: A country name and uri
		String country = "England";
		String uri = String.format(
				"http://localhost:%d/teams?teamsCountry=%s", serverPort, country);
		
		// When: An HTTP Request is sent to the service
		ResponseEntity<List<Teams>> response = 
				restTemplate.exchange(
						uri, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
		
		// Then: The response status is 200 (OK)
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		
	}
	
	protected void assertErrorMessageValid(Map<String, Object> error, HttpStatus status) {
	    assertThat(error)
	      .containsKey("message")
	      .containsEntry("status code", status.value())
	      .containsEntry("uri", "/jeeps")
	      .containsKey("timestamp")
	      .containsEntry("reason", status.getReasonPhrase());
	  }
		 

}
