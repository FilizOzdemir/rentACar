package com.etiya.rentACar.business.requests.invoiceRequests;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateInvoiceRequest {

	private int id;
	private String invoiceNumber;
	private LocalDate createDate;
	private double totalPrice;
	private int customerId;
	private int rentalId;
}
