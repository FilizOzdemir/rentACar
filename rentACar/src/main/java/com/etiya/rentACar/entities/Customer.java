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
@Table(name="customers")// Müsteri Tablosu
@Entity
public class Customer {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="national_id")
    private String nationalId;
    

    @OneToMany(mappedBy="customer")//kira tab ile ilişkilendirme
    private List<Rental> rentals;
    
    @OneToMany(mappedBy = "customer")//fatura tab ile ilişkilendirme
    private List<Invoice> invoices;

    @OneToMany(mappedBy = "customer")//ödeme tab ile ilişkilendirme
    private List<Payment> payments;
}
