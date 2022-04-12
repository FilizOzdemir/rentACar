package com.etiya.rentACar.business.responses.rentalResponses;

import java.time.LocalDate;
import java.util.List;

import com.etiya.rentACar.business.responses.orderedAdditionalPropertyResponses.OrderedAdditionalPropertyDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalDto {
	
	@JsonIgnore
	private int id;
	private LocalDate rentDate;
	private LocalDate returnDate;

	private String carDescription;
	
	private String customerFirstName;//customer adı
	private String customerLastName;//customer soyadı
	
	private String rentCityName;
	private String returnCityName;
	
	private double dailyPrice;
	private double beforeRentKilometer;
	private double afterRentKilometer;
	
	private List<OrderedAdditionalPropertyDto> orderedAdditionalProperties;
}
