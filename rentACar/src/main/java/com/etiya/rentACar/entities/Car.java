package com.etiya.rentACar.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars") // Arabaların Tablosu
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id") // tablonun id alanı
	private int id;

	@Column(name = "dailyPrice")
	private double dailyPrice;// günlük fıyat

	@Column(name = "description")
	private String description;// açıklama

	@Column(name = "modelYear")
	private double modelYear;// arabanin model yili
	
	@Column(name="car_state")//arabanin durumu
	private CarStates carState;
	
	@Column(name="kilometer")//arabanın kilometresi
	private double kilometer;
	
	@ManyToOne // çok'dan bir'e
	@JoinColumn(name = "color_id") // color tab. id ye göre
	private Color color;

	@ManyToOne
	@JoinColumn(name = "brand_id") // brand tab id'ye göre
	private Brand brand;
	
	@OneToMany(mappedBy = "car")
	private List<Damage> damages;//bir araba bir çok kez hasar alabilir
	
	@OneToMany(mappedBy = "car")
	private List<Maintenance> maintenances;//bir araba bir çok kez bakıma gidebilir

	@ManyToOne//bir şehir de birden fazla araba olabilir
	@JoinColumn(name="city_id")
	private City city;
	
	@OneToMany(mappedBy = "car")//bir araba bir çok kez kiralanabilir
	private List<Rental> rentals;


}
