package com.etiya.rentACar.business.responses.orderedAdditionalPropertyResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderedAdditionalPropertyDto {
	private int id;
	private String rentalId;
	private String additionalPropertyName;
	private int additionalPropertyDailyPrice;
	private List<OrderedAdditionalPropertyDto> orderedAdditionalProperty;//ek hızmetler kısmının içindekilerini getirir.
}
