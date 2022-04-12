package com.etiya.rentACar.business.requests.orderedAdditionalPropertyRequets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderedAdditionalPropertyRequest {

	private int id;
	private int rentalId;
	private int additionalPropertyId;
}
