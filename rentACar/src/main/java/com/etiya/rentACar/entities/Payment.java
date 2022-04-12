package com.etiya.rentACar.entities;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="payments")//ödeme tablosu
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id") 
	private int id;

	@Column(name="payment_number")
	private String paymentNumber;

	@Column(name="totalPrice")//toplam fiyat
	private double totalPrice;

	@ManyToOne
	@JoinColumn(name="customer_id",referencedColumnName = "id")
	private Customer customer;

	@OneToOne
	@JoinColumn(name="invoice_id",referencedColumnName = "id")//bir faturanın bir ödemesi olur
	private Invoice invoice;

	@OneToOne
	@JoinColumn(name="rental_id")//bire bir ilişki (bir kiralamanın bir ödemesi olur)
	private Rental rental;
	

}
