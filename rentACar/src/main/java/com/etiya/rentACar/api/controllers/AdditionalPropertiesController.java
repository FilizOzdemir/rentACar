package com.etiya.rentACar.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.etiya.rentACar.business.abstracts.AdditionalPropertyService;
import com.etiya.rentACar.business.requests.additionalPropertyRequests.CreateAdditionalPropertyRequest;
import com.etiya.rentACar.business.requests.additionalPropertyRequests.DeleteAdditionalPropertyRequest;
import com.etiya.rentACar.business.requests.additionalPropertyRequests.UpdateAdditionalPropertyRequest;
import com.etiya.rentACar.business.responses.additionalPropertyResponses.ListAdditionalPropertyDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;



@RestController
@RequestMapping("/api/additionalproperties")
public class AdditionalPropertiesController {

	private AdditionalPropertyService additionalPropertyService;

	public AdditionalPropertiesController(AdditionalPropertyService additionalPropertyService) {

		this.additionalPropertyService = additionalPropertyService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody @Valid CreateAdditionalPropertyRequest createAdditionalPropertyRequest) {
		return this.additionalPropertyService.add(createAdditionalPropertyRequest);
	}

	@PostMapping("/update")
	public Result update(@RequestBody @Valid UpdateAdditionalPropertyRequest updateAdditionalPropertyRequest) {
		return this.additionalPropertyService.update(updateAdditionalPropertyRequest);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestBody @Valid DeleteAdditionalPropertyRequest deleteAdditionalPropertyRequest) {
		return this.additionalPropertyService.delete(deleteAdditionalPropertyRequest);
	}

	@GetMapping("/getall")
	public DataResult<List<ListAdditionalPropertyDto>> getAll() {

		return this.additionalPropertyService.getAll();
	}
}
