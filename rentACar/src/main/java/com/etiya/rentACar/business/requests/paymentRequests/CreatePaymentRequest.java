package com.etiya.rentACar.business.requests.paymentRequests;

import java.util.List;

import com.etiya.rentACar.business.requests.creditCardRequests.CreateCreditCardRequest;
import com.etiya.rentACar.business.requests.invoiceRequests.CreateInvoiceRequest;
import com.etiya.rentACar.business.requests.orderedAdditionalPropertyRequets.CreateOrderedAdditionalPropertyRequest;
import com.etiya.rentACar.business.requests.rentalRequests.CreateRentalRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentRequest {

	@JsonIgnore
	private int id;
	private String paymentNumber;
    private int customerId;
    private CreateCreditCardRequest creditCard;
    private CreateRentalRequest createRentalRequest;
    private CreateInvoiceRequest createInvoiceRequest;
    private List<CreateOrderedAdditionalPropertyRequest> createOrderedAdditionalPropertyRequest;
    
	
}
