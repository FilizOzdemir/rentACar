package com.etiya.rentACar.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etiya.rentACar.entities.Invoice;

@Repository
public interface InvoiceDao extends JpaRepository<Invoice, Integer> {

	List<Invoice> getByCustomerId(int customerId);//müşterileri id
	List<Invoice> findByCreateDateBetween(LocalDate startDate,LocalDate endDate);//ikisi arasında ki fark
	
}
