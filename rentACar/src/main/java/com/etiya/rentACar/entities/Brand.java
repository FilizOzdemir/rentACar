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
@Table(name = "brands") // marka tablosu
public class Brand {

	// GenerationType.IDENTITY: Veritabanı içindeki Auto Increment özelligini
	// kullanılarak sıradaki değerin üretilmesini veritabanına bırakır.

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id") // tablonun id alanı
	private int id;

	@Column(name = "name")
	private String name;// marka ismi

	@OneToMany(mappedBy = "brand") // bir'den çok / bir markanın bir çok arabası olabilir
	private List<Car> cars;

}
