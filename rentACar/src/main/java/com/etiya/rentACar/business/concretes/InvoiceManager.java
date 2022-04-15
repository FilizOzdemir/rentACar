package com.etiya.rentACar.business.concretes;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.etiya.rentACar.business.abstracts.InvoiceService;
import com.etiya.rentACar.business.abstracts.RentalService;
import com.etiya.rentACar.business.constants.messages.BusinessMessages;
import com.etiya.rentACar.business.requests.invoiceRequests.CreateInvoiceRequest;
import com.etiya.rentACar.business.requests.invoiceRequests.DeleteInvoiceRequest;
import com.etiya.rentACar.business.requests.invoiceRequests.UpdateInvoiceRequest;
import com.etiya.rentACar.business.responses.invoiceResponses.ListInvoiceDto;
import com.etiya.rentACar.business.responses.rentalResponses.RentalDto;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.InvoiceDao;
import com.etiya.rentACar.entities.Invoice;

@Service
public class InvoiceManager implements InvoiceService {

	private InvoiceDao invoiceDao;
	private ModelMapperService modelMapperService;
	private RentalService rentalService;
	
	
	public InvoiceManager(InvoiceDao invoiceDao, ModelMapperService modelMapperService, RentalService rentalService) {
		this.invoiceDao = invoiceDao;
		this.modelMapperService = modelMapperService;
		this.rentalService = rentalService;
	}

	@Override
	public DataResult<Invoice> add(CreateInvoiceRequest createInvoiceRequest) {
		int rentalId=createInvoiceRequest.getRentalId();
		RentalDto rentalDto=this.rentalService.getById(rentalId);
		
		Period day =Period.between(rentalDto.getRentDate(), rentalDto.getReturnDate());//iki tarih arasını alır ve gün'e/day atar
		int daysCount=day.getDays();
		
		Invoice invoice= this.modelMapperService.forRequest().map(createInvoiceRequest, Invoice.class);
		invoice.setRentDate(rentalDto.getRentDate());
		invoice.setReturnDate(rentalDto.getReturnDate());
		//invoice.setTotalPrice(daysCount);
		invoice.setTotalRentDay(daysCount);
		this.invoiceDao.save(invoice);
		
		return new SuccessDataResult<Invoice>(invoice,BusinessMessages.InvoiceMessages.INVOICE_ADDED);
	}

	@Override
	public Result update(UpdateInvoiceRequest updateInvoiceRequest) {
		Invoice result = this.modelMapperService.forRequest().map(updateInvoiceRequest, Invoice.class);
		this.invoiceDao.save(result);
		return new SuccessResult(BusinessMessages.InvoiceMessages.INVOICE_UPDATED);
	}

	@Override
	public Result delete(DeleteInvoiceRequest deleteInvoiceRequest) {
		int invoiceId = deleteInvoiceRequest.getId();
		this.invoiceDao.deleteById(invoiceId);
		return new SuccessResult(BusinessMessages.InvoiceMessages.INVOICE_DELETED);
	}

	@Override
	public DataResult<List<ListInvoiceDto>> getAll() {
		List<Invoice> invoices = this.invoiceDao.findAll();
		List<ListInvoiceDto> response = invoices.stream().map(invoice -> modelMapperService.forDto().map(invoice, ListInvoiceDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<ListInvoiceDto>>(response);
	}
	@Override
	public DataResult<Invoice> getById(int id){
		Invoice invoice=this.invoiceDao.getById(id);
		return new SuccessDataResult<Invoice>(invoice);
	}

	@Override
	public DataResult<List<ListInvoiceDto>> getByCustomerId(int customerId) {
		List<Invoice> invoices = this.invoiceDao.getByCustomerId(customerId);
		List<ListInvoiceDto> response = invoices.stream().map(invoice -> modelMapperService.forDto().map(invoice, ListInvoiceDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<ListInvoiceDto>>(response);
	}

	@Override
	public DataResult<List<ListInvoiceDto>> findByCreateDateBetween(LocalDate startDate, LocalDate endDate) {
		List<Invoice> invoices = this.invoiceDao.findByCreateDateBetween(startDate, endDate);
		List<ListInvoiceDto> response = invoices.stream().map(invoice -> modelMapperService.forDto().map(invoice, ListInvoiceDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<ListInvoiceDto>>(response);
	}
	
	
}
