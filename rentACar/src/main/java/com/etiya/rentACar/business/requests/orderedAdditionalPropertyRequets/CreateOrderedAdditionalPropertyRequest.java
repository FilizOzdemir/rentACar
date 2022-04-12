package com.etiya.rentACar.business.requests.orderedAdditionalPropertyRequets;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderedAdditionalPropertyRequest {

	@JsonIgnore
	private int id;
	private int rentalId;
	private int additionalPropertyId;
}
