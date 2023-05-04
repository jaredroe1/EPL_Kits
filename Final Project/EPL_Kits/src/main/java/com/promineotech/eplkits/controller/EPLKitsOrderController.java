package com.promineotech.eplkits.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.eplkits.entity.Orders;
import com.promineotech.eplkits.entity.OrdersEntry;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@Validated
@RequestMapping("/orders")
public interface EPLKitsOrderController {	
	@Operation(summary = "Create a kit")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Save Kit",
				content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Orders.class))}),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	})
	 
				
	  @PostMapping
	  @ResponseStatus(code = HttpStatus.CREATED)
	  Orders createOrders(@Valid @RequestBody OrdersEntry ordersEntry);
	
	@Operation(summary = "Update a kit")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Update Kit",
				content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Orders.class))}),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	})
	  @PutMapping("/update")
	  @ResponseStatus(code = HttpStatus.OK)
	  Orders updateKit(@Valid @RequestBody OrdersEntry ordersEntry,
			  @Parameter (description = "Order ID to be updated")
			  @RequestParam(required = true)
			  @PathVariable Long ordersPK);
	
	@Operation(summary = "Delete a Kit")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Deleted Kit",
				content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Orders.class))}),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	})
	  @DeleteMapping("/delete")
	@ResponseStatus(code = HttpStatus.OK)
	Orders deleteKit(@Parameter(description = "Order ID to be deleted")
					 @RequestParam(required = true)
					 @PathVariable Long ordersPK);		
	
	
	
	  
	  
	  
	  
	  
	
	

}
