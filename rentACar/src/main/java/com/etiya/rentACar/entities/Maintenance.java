package com.etiya.rentACar.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity //veri tab kaynagi
@Table(name = "maintenances") // Arabaya ait Bakım Tablosu
public class Maintenance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id") // bakım tablosunun id alanı
	private int id;

	@Column(name = "dateAdded") // aracın bakıma giris tarihi
	private LocalDate dateAdded;

	@Column(name = "dateReturned") // aracın bakımdan çıkıs tarihi
	private LocalDate dateReturned;

	@Column(name = "description") // aracın neden bakımda old aciklamasi
	private String description;

	@ManyToOne
	@JoinColumn(name = "car_id")//carId
	private Car car;

	

}
