package com.etiya.rentACar.business.requests.paymentRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePaymentRequest {
	
	private int id;
	private double totalPrice;

	private int rentalId;
	private int invoiceId;
}
