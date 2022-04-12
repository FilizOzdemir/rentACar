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

import com.etiya.rentACar.business.abstracts.PaymentService;
import com.etiya.rentACar.business.requests.paymentRequests.CreatePaymentRequest;
import com.etiya.rentACar.business.requests.paymentRequests.DeletePaymentRequest;
import com.etiya.rentACar.business.requests.paymentRequests.UpdatePaymentRequest;
import com.etiya.rentACar.business.responses.paymentResponses.ListPaymentDto;

import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

	private PaymentService paymentService;

	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody @Valid CreatePaymentRequest createPaymentRequest) {
		return this.paymentService.add(createPaymentRequest);
		
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody @Valid UpdatePaymentRequest updatePaymentRequest) {
		return this.paymentService.update(updatePaymentRequest);
		
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestBody @Valid DeletePaymentRequest deletePaymentRequest) {
		return this.paymentService.delete(deletePaymentRequest);
		
	}
	 @GetMapping("/getall")
	    public DataResult<List<ListPaymentDto>> getAll() {
	        return this.paymentService.getAll();

	    }
}



