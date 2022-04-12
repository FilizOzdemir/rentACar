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
@Table(name = "credit_cards") //kredi kartı tablosu
public class CreditCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id") 
	private int id;
	
	@Column(name ="credit_card_Number" ,length = 16)// kredi kartı num
	private String creditCardNumber;
	
	@Column(name="first_name")
	private String firstName;

    @Column(name="last_name")
    private String lastName;
    
    @Column(name="cvv")//Kart Güvenlik Kodu
    private String cvv;
    
    @Column(name="expiration_date")//Son Kullanma Tarihi
	private String expirationDate;
}
