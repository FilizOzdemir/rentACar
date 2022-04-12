package com.etiya.rentACar.business.requests.carRequests;

import com.etiya.rentACar.entities.CarStates;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {
	
	private int id;

	private double dailyPrice;//günlük fiyat

	private String description;//açılama
	
	private double modelYear;//araba modeli
	
	private int cityId;
	
	private int colorId;
	
	private int brandId;

	private CarStates carStateName;
	
	private double kilometer;
	
}
