package com.etiya.rentACar.business.responses.paymentResponses;


import java.util.List;

import com.etiya.rentACar.business.responses.orderedAdditionalPropertyResponses.OrderedAdditionalPropertyDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {

	private String rentalCustomerCustomerFirstName;// bu kısıma bak!!!
	private String rentalCustomerCustomerLastName;
	private String invoiceInvoicesNumber;
	private double totalPrice;
    private List<OrderedAdditionalPropertyDto> rentalAdditionalProperties;
}
