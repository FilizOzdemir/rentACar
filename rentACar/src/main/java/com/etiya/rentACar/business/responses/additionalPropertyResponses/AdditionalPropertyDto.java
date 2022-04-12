package com.etiya.rentACar.business.responses.additionalPropertyResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdditionalPropertyDto {

	private int id;
	private String name;//AdditionalPropertyname 
	private double dailyPrice;
}
