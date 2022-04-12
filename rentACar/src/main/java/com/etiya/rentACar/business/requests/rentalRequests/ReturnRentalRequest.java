package com.etiya.rentACar.business.requests.rentalRequests;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnRentalRequest {

	private int id;
	private int carId;
	private int returnCityId;
	private LocalDate returnDate;
	private double afterRentKilometer;
}
