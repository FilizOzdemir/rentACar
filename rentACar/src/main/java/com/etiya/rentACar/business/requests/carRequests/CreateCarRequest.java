package com.etiya.rentACar.business.requests.carRequests;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.etiya.rentACar.entities.CarStates;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {
	
	@JsonIgnore
	private int id;//JsonIgnore:frontend kısmından id gelmemesini sağlar

	@NotNull
	@Min(1)
	@Max(20000)
	private double dailyPrice;//günlük fiyat

	@NotNull
	@Length(min=2,max=50)
	private String description;//açılama
	
	@NotNull
	@Min(2015)//2015 yılı öncesi araba modeli olamaz min 2015!
	private double modelYear;//araba modeli
	
	private int cityId;
	
	@NotNull
	private int colorId;
	
	@NotNull
	private int brandId;
	
	@NotNull
	private CarStates carStateName;

	private double kilometer;
}
