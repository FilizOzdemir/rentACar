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
@Entity
@Table(name = "damages") // arabaya ait hasar tablosu
public class Damage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id") // tablonun id alanı
	private int id;

	@Column(name = "accidentDate") // tarih alanı
	private LocalDate accidentDate; //date:accidentDate =kaza tarihi 

	@Column(name = "description") // acıklama alanı
	private String description;

	@ManyToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name = "car_id")
	private Car car;
}
