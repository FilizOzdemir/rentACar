package com.etiya.rentACar.business.requests.maintenanceRequests;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMaintenanceRequest {

	//@JsonIgnore: JSON verisinde gözükmesi istenmeyen anahtarlar özel olarak belirtmek istenirse kullanılır.
	
	@JsonIgnore
	private int id;
	
	@NotNull
	//@FutureOrPresent //Gelecek tarih ya da şimdiki tarih olmalıdır.
	private LocalDate dateAdded;//bakıma giris tarihi
	
	@NotNull
	//@FutureOrPresent //Gelecek tarih ya da şimdiki tarih olmalıdır.
	private LocalDate dateReturned;//bakımdan çıkıs tarihi

	@Length(min=1,max=100)
	private String description;//aciklama
	
	private int carId;

	
}
