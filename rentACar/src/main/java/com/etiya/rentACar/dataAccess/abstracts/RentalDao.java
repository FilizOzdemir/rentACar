package com.etiya.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etiya.rentACar.entities.Rental;

@Repository
public interface RentalDao extends JpaRepository<Rental, Integer> {

	Boolean existsById(int rentalId);
	
	List<Rental> getByCarId(int carId);
	
	Rental getById(int id);//kira id'si
	Rental getByCustomerId(int id);//kira tab müşteri id'i
	
}
