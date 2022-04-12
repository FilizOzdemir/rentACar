package com.etiya.rentACar.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "creditCards") //kredi kartı tablosu
public class CreditCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id") 
	private int id;
	
	@Column(name ="creditCardNumber")// kredi kartı num
	private String creditCardNumber;
	
	@Column(name="firstName")
	private String firstName;

    @Column(name="lastName")
    private String lastName;
    
    @Column(name="cvv")//Kart Güvenlik Kodu
    private String cvv;
    
    @Column(name="expirationDate")//Son Kullanma Tarihi
	private String expirationDate;
}
