package com.etiya.rentACar.business.responses.paymentResponses;

import java.util.List;

import com.etiya.rentACar.business.responses.orderedAdditionalPropertyResponses.OrderedAdditionalPropertyDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListPaymentDto {

	private String paymentNumber;
	private String rentalCustomerCustomerFirstName;//rentalda ki customer'ın customerda ki firstname'ini çeker!!!
	private String rentalCustomerCustomerLastName;//rentalda ki customer'ın customerda ki lastname'ini çeker!!!
	private String invoiceInvoicesNumber;//invoicede ki invoice number kısmını çeker!!!
	private double totalPrice;
    private List<OrderedAdditionalPropertyDto> rentalAdditionalProperties;
	
}
