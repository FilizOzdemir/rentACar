package com.etiya.rentACar.business.requests.damageRequests;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateDamageRequest {
	
	@JsonIgnore
	private int id;
	
	@NotNull
	private int carId;//araba id =carId
	
	
	//@PastOrPresent //@PastOrPresent : Tarih alanlarına uygulanabilir değerin geçmiş bir tarih ya da şimdi olmasını zorunlu kılar!!!
	private LocalDate accidentDate;//hasar tarihi
	
	
	@Length(min=1,max=100)
	private String description;//hasar aciklamasi
}
