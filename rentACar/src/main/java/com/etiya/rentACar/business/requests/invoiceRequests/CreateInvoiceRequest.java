package com.etiya.rentACar.business.requests.invoiceRequests;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInvoiceRequest {

	@JsonIgnore
	private int id;
	
	private String invoiceNumber;//fatura no.
	private LocalDate createDate;
	private double totalPrice;
	private int customerId;
	private int rentalId;
	
}
