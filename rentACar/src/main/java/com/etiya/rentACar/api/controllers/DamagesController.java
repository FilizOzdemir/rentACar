package com.etiya.rentACar.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.rentACar.business.abstracts.DamageService;
import com.etiya.rentACar.business.requests.damageRequests.CreateDamageRequest;
import com.etiya.rentACar.business.requests.damageRequests.DeleteDamageRequest;
import com.etiya.rentACar.business.requests.damageRequests.UpdateDamageRequest;
import com.etiya.rentACar.business.responses.damageResponses.ListDamageDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

@RestController
@RequestMapping("/api/damages")
public class DamagesController {

	private DamageService damageService;

	public DamagesController(DamageService damageService) {
		this.damageService = damageService;
	}

	@PostMapping("/add")
    public Result add(@RequestBody CreateDamageRequest createDamageRequest) {
        return this.damageService.add(createDamageRequest);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdateDamageRequest updateDamageRequest) {
        return this.damageService.update(updateDamageRequest);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody DeleteDamageRequest deleteDamageRequest) {
        return this.damageService.delete(deleteDamageRequest);
    }
    
	@GetMapping("/getall")
	public DataResult<List<ListDamageDto>> getAll() {
		return this.damageService.getAll();
	}

	@GetMapping("/getallbycarid")
	public DataResult<List<ListDamageDto>> getAllByCarId(@RequestParam("carId") int id) {
		return this.damageService.getAllByCarId(id);
	}

	@GetMapping("/get/getallpaged")
	public DataResult<List<ListDamageDto>> getAllPaged(@RequestParam int pageNo, @RequestParam int pageSize) {

		return this.damageService.getAllPaged(pageNo, pageSize);

	}

	@GetMapping("/get/getallsorted")
	public DataResult<List<ListDamageDto>> getAllSorted(@RequestParam String field, @RequestParam String option) {

		return this.damageService.getAllSorted(field, option);

	}

	

}
