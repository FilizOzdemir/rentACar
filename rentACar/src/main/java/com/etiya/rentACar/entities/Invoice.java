package com.etiya.rentACar.entities;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="invoices")//fatura tablosu
@Entity
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id") // tablonun id alanı
	private int id;
	
	@Column(name="invoice_number")//fatura No
	private String invoiceNumber;
	
	@Column(name="create_date")//Oluşturma Tarihi
	private LocalDate createDate;
	
	@Column(name="rent_date")//kiralama tarihi
	private LocalDate rentDate;
	
	@Column(name="return_date")//dönüş tarihi
	private LocalDate returnDate;
	
	@Column(name="total_rent_day")//toplam kiralama günü
	private int totalRentDay;
	
	@Column(name="total_price")//toplam fiyat
	private double totalPrice;
	
	@ManyToOne
	@JoinColumn(name="customer_id")//müşteri id
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="rental_id")
	private Rental rental;
	
	@OneToOne(mappedBy = "invoice")
	private Payment payment;
	
	
}
