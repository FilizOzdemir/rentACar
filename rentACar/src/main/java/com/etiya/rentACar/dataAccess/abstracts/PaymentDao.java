package com.etiya.rentACar.dataAccess.abstracts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etiya.rentACar.entities.Payment;

@Repository
public interface PaymentDao extends JpaRepository<Payment, Integer>{

}
