package com.etiya.rentACar.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cities") // sehir tablosu
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy = "rentCityId")
	private List<Rental> rentCityRentals;
	
	@OneToMany(mappedBy = "returnCityId")
	private List<Rental> returnCityRentals;
	
	@OneToMany(mappedBy = "city")//bir araba bir şehirde olabilir.
	private List<Car> cars;
	
	
}
