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

import com.etiya.rentACar.business.abstracts.RentalService;
import com.etiya.rentACar.business.requests.rentalRequests.CreateRentalRequest;
import com.etiya.rentACar.business.requests.rentalRequests.DeleteRentalRequest;
import com.etiya.rentACar.business.requests.rentalRequests.ReturnRentalRequest;
import com.etiya.rentACar.business.requests.rentalRequests.UpdateRentalRequest;
import com.etiya.rentACar.business.responses.rentalResponses.ListRentalDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;


@RestController
@RequestMapping("/api/rentals")
public class RentalsController {

	private RentalService rentalService;

	public RentalsController(RentalService rentalService) {
		this.rentalService = rentalService;
	}
	@PostMapping("/add")
    public Result add(@RequestBody @Valid CreateRentalRequest createRentalRequest) {
        return this.rentalService.add(createRentalRequest);
    }

    @PutMapping("/update")
    public Result update(@RequestBody @Valid UpdateRentalRequest updateRentalRequest) {
        return this.rentalService.update(updateRentalRequest);
    }
    @DeleteMapping("/delete")
    public Result delete(@RequestBody @Valid DeleteRentalRequest deleteRentalRequest) {
    	return this.rentalService.delete(deleteRentalRequest);
    }

    @PostMapping("/returnRental")
    public Result returnRental(@RequestBody @Valid ReturnRentalRequest returnRentalRequest) {
    	return this.rentalService.returnRental(returnRentalRequest);
    }
    @GetMapping("/getall")
    public DataResult<List<ListRentalDto>> getAll() {
        return this.rentalService.getAll();
    	//return rentalService.getAll();
    }


   
}
