package com.etiya.rentACar.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="rentals")// Kira Tablosu
@Entity
public class Rental {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id")
	private int id;
	
	@Column(name="rent_date")//kira tarihi
	private LocalDate rentDate;
	
	@Column(name="return_date")//iade tarihi
	private LocalDate returnDate;
	
	@Column(name="after_rent_kilometer")
	private double afterRentKilometer;
	
	@Column(name="before_rent_kilometer")
	private double beforeRentKilometer;
	
	@ManyToOne//hangi şehirde kiraladık
	@JoinColumn(name="rent_city_id", referencedColumnName="id")
	private City rentCityId;
	
	@ManyToOne//Hangi şehirde arabayı teslimat ettik
	@JoinColumn(name="return_city_id", referencedColumnName="id") 
	private City returnCityId;
	
	@Column(name="daily_price")
	private double dailyPrice;//fiyat 
	
	@ManyToOne
	@JoinColumn(name="car_id")
	private Car car;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;

	@OneToMany(mappedBy = "rental")
	private List<Invoice> invoices;	
	
	@OneToMany(mappedBy = "rental")
	private List<OrderedAdditionalProperty> orderedAdditionalProperties;

	@OneToOne(mappedBy = "rental")
	private Payment payment;
}
