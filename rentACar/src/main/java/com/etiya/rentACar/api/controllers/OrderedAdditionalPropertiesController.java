package com.etiya.rentACar.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.rentACar.business.abstracts.OrderedAdditionalPropertyService;
import com.etiya.rentACar.business.requests.orderedAdditionalPropertyRequets.CreateOrderedAdditionalPropertyRequest;
import com.etiya.rentACar.business.requests.orderedAdditionalPropertyRequets.DeleteOrderedAdditionalPropertyRequest;
import com.etiya.rentACar.business.requests.orderedAdditionalPropertyRequets.UpdateOrderedAdditionalPropertyRequest;
import com.etiya.rentACar.business.responses.orderedAdditionalPropertyResponses.ListOrderedAdditionalPropertyDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

@RestController
@RequestMapping("/api/orderedAdditionalProperties")
public class OrderedAdditionalPropertiesController {

	private OrderedAdditionalPropertyService orderedAdditionalPropertyService;

	public OrderedAdditionalPropertiesController(OrderedAdditionalPropertyService orderedAdditionalPropertyService) {
		this.orderedAdditionalPropertyService = orderedAdditionalPropertyService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody @Valid CreateOrderedAdditionalPropertyRequest createOrderedAdditionalPropertyRequest) {
		return this.orderedAdditionalPropertyService.add(createOrderedAdditionalPropertyRequest);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody @Valid UpdateOrderedAdditionalPropertyRequest updateOrderedAdditionalPropertyRequest) {
		return this.orderedAdditionalPropertyService.update(updateOrderedAdditionalPropertyRequest);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestBody DeleteOrderedAdditionalPropertyRequest deleteOrderedAdditionalPropertyRequest) {
		return this.orderedAdditionalPropertyService.delete(deleteOrderedAdditionalPropertyRequest);
	}
	
	@GetMapping("/getall")
	public DataResult<List<ListOrderedAdditionalPropertyDto>> getAll(){
		return this.orderedAdditionalPropertyService.getAll();
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
