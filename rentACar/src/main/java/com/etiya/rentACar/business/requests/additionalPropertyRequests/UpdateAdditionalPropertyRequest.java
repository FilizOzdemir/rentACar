package com.etiya.rentACar.business.requests.additionalPropertyRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAdditionalPropertyRequest {
	
	private int id;
	private String name;
	private double dailyPrice;
}
