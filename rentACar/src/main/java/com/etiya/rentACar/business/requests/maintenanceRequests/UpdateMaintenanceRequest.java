package com.etiya.rentACar.business.requests.maintenanceRequests;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMaintenanceRequest {
	
	private int id;
	
	//@FutureOrPresent //Gelecek tarih ya da şimdiki tarih olmalıdır.
	private LocalDate dateAdded;//bakıma giris tarihi
	
	//@FutureOrPresent //Gelecek tarih ya da şimdiki tarih olmalıdır.
	private LocalDate dateReturned;//bakımdan çıkıs tarihi

	@Length(min=1,max=100)
	private String description;//aciklama
	
	@NotNull
	private int carId;

}
