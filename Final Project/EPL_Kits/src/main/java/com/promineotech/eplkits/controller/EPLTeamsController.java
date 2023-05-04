package com.promineotech.eplkits.controller;

import java.util.List;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.eplkits.entity.Names;
import com.promineotech.eplkits.entity.Numbers;
import com.promineotech.eplkits.entity.Shoes;
import com.promineotech.eplkits.entity.Teams;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping
@OpenAPIDefinition(info = @Info(title = "EPL Teams Service"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server.")})
public interface EPLTeamsController {
	
	  // @formatter:off
	  @Operation(
	      summary = "Returns a list of Teams",
	      description = "Returns a list of Team Names given a country name",
	      responses = {
	          @ApiResponse(
	              responseCode = "200",
	              description = "A list of Teams is returned",
	              content = @Content(
	                  mediaType = "application/json",
	                  schema = @Schema(implementation = Teams.class))),
	          @ApiResponse(
	              responseCode = "400",
	              description = "The request parameters are invalid",
	              content = @Content(mediaType = "application/json")),
	          @ApiResponse(
	              responseCode = "404",
	              description = "No teams were found with the input criteria",
	              content = @Content(mediaType = "application/json")),
	          @ApiResponse(
	              responseCode = "500",
	              description = "An unplanned error occurred.",
	              content = @Content(mediaType = "application/json"))
	      },
	      parameters = {
	          @Parameter(
	              name = "teamsCountry",
	              allowEmptyValue = false,
	              required = false,
	              description = "The country name (i.e., 'England')"),
	         
	      }
	      
	      )
	  
	  @GetMapping("/teams")
	  @ResponseStatus(code = HttpStatus.OK)
	  public List<Teams> fetchTeams(
		  @Length(max = 40)
		  @Pattern(regexp = "[\\w\\s]*")
	      @RequestParam(required = false)
	          String teamsCountry);
	  
	  @Operation(
		      summary = "Returns a list of shoes",
		      description = "Returns a list of shoes given a shoe type",
		      responses = {
		          @ApiResponse(
		              responseCode = "200",
		              description = "A list of shoes is returned",
		              content = @Content(
		                  mediaType = "application/json",
		                  schema = @Schema(implementation = Shoes.class))),
		          @ApiResponse(
		              responseCode = "400",
		              description = "The request parameters are invalid",
		              content = @Content(mediaType = "application/json")),
		          @ApiResponse(
		              responseCode = "404",
		              description = "No Jeeps were found with the input criteria",
		              content = @Content(mediaType = "application/json")),
		          @ApiResponse(
		              responseCode = "500",
		              description = "An unplanned error occurred.",
		              content = @Content(mediaType = "application/json"))
		      },
		      parameters = {
		          @Parameter(
		              name = "shoesType",
		              allowEmptyValue = true,
		              required = false,
		              description = "The shoe type (i.e., 'FG')"),
		         
		      }
		      
		      )
	  
	  @GetMapping("/shoes")
	  @ResponseStatus(code = HttpStatus.OK)
	  public List<Shoes> fetchShoes(
			  @Length(max = 30)
			  @Pattern(regexp = "[\\w\\s]*")
			  @RequestParam(required = false)
			  String shoesType);
	  
	  @Operation(
		      summary = "Returns a list of names",
		      description = "Returns a list of players names given a league",
		      responses = {
		          @ApiResponse(
		              responseCode = "200",
		              description = "A list of names is returned",
		              content = @Content(
		                  mediaType = "application/json",
		                  schema = @Schema(implementation = Names.class))),
		          @ApiResponse(
		              responseCode = "400",
		              description = "The request parameters are invalid",
		              content = @Content(mediaType = "application/json")),
		          @ApiResponse(
		              responseCode = "404",
		              description = "No names were found with the input criteria",
		              content = @Content(mediaType = "application/json")),
		          @ApiResponse(
		              responseCode = "500",
		              description = "An unplanned error occurred.",
		              content = @Content(mediaType = "application/json"))
		      },
		      parameters = {
		          @Parameter(
		              name = "namesLeague",
		              allowEmptyValue = true,
		              required = false,
		              description = "The league (i.e., 'EPL')"),
		         
		      }
		      
		      )
	  
	  @GetMapping("/names")
	  @ResponseStatus(code = HttpStatus.OK)
	  public List<Names> fetchNames(
			  @Length(max = 30)
			  @Pattern(regexp = "[\\w\\s]*")
			  @RequestParam(required = false)
			  String namesLeague);
	  
	  @Operation(
		      summary = "Returns a list of jersey numbers",
		      description = "Returns a list of numbers to customize jerseys",
		      responses = {
		          @ApiResponse(
		              responseCode = "200",
		              description = "A list of numbers is returned",
		              content = @Content(
		                  mediaType = "application/json",
		                  schema = @Schema(implementation = Numbers.class))),
		          @ApiResponse(
		              responseCode = "400",
		              description = "The request parameters are invalid",
		              content = @Content(mediaType = "application/json")),
		          @ApiResponse(
		              responseCode = "404",
		              description = "No numbers were found with the input criteria",
		              content = @Content(mediaType = "application/json")),
		          @ApiResponse(
		              responseCode = "500",
		              description = "An unplanned error occurred.",
		              content = @Content(mediaType = "application/json"))
		      },
		      parameters = {
		          @Parameter(
		              name = "numbersPosition",
		              allowEmptyValue = false,
		              required = false,
		              description = "The position (i.e., 'Keeper', 'Defense', 'Attack')"),
		         
		      }
		      
		      )
	  @GetMapping("/numbers")
	  @ResponseStatus(code = HttpStatus.OK)
	  public List<Numbers> fetchNumbers(
			  @Length(max = 30)
			  @Pattern(regexp = "[\\w\\s]*")
			  @RequestParam(required = false)
			  String numbersPosition);
	  
	  
	      
	   
	//@formatter:on

}
