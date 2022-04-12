package com.etiya.rentACar.api.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.rentACar.business.abstracts.InvoiceService;
import com.etiya.rentACar.business.requests.invoiceRequests.CreateInvoiceRequest;
import com.etiya.rentACar.business.requests.invoiceRequests.DeleteInvoiceRequest;
import com.etiya.rentACar.business.requests.invoiceRequests.UpdateInvoiceRequest;
import com.etiya.rentACar.business.responses.invoiceResponses.ListInvoiceDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

@RestController
@RequestMapping("/api/invoices")
public class InvoicesController {

	private InvoiceService invoiceService;

	public InvoicesController(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody @Valid CreateInvoiceRequest createInvoiceRequest) {
		return this.invoiceService.add(createInvoiceRequest);

	}

	@PutMapping("/update")
	public Result update(@RequestBody @Valid UpdateInvoiceRequest updateInvoiceRequest) {
		return this.invoiceService.update(updateInvoiceRequest);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestBody @Valid DeleteInvoiceRequest deleteInvoiceRequest) {
		return this.invoiceService.delete(deleteInvoiceRequest);
	}

	@GetMapping("/getAll")
	public DataResult<List<ListInvoiceDto>> getAll() {
		return this.invoiceService.getAll();
	}

	@GetMapping("/findCreateDate")
	public DataResult<List<ListInvoiceDto>> findCreateDate(
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
		return this.invoiceService.findByCreateDateBetween(startDate, endDate);
	}

	@GetMapping("/getAllCustomerId")
	public DataResult<List<ListInvoiceDto>> getByCustomerId(@RequestParam int customerId) {
		return this.invoiceService.getByCustomerId(customerId);
	}

}
