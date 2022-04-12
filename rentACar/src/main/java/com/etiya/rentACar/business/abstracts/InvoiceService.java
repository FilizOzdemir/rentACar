package com.etiya.rentACar.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import com.etiya.rentACar.business.requests.invoiceRequests.CreateInvoiceRequest;
import com.etiya.rentACar.business.requests.invoiceRequests.DeleteInvoiceRequest;
import com.etiya.rentACar.business.requests.invoiceRequests.UpdateInvoiceRequest;
import com.etiya.rentACar.business.responses.invoiceResponses.ListInvoiceDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

public interface InvoiceService {

	Result add(CreateInvoiceRequest createInvoiceRequest);
	Result update(UpdateInvoiceRequest updateInvoiceRequest);
	Result delete(DeleteInvoiceRequest deleteInvoiceRequest);
	
	DataResult<List<ListInvoiceDto>> getAll();
	DataResult<List<ListInvoiceDto>> getByCustomerId(int customerId);
	DataResult<List<ListInvoiceDto>> findByCreateDateBetween(LocalDate startDate,LocalDate endDate);//iki tarih arasındaki fark
}
