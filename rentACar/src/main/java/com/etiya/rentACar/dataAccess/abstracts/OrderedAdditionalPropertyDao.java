package com.etiya.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etiya.rentACar.entities.OrderedAdditionalProperty;

@Repository
public interface OrderedAdditionalPropertyDao extends JpaRepository<OrderedAdditionalProperty, Integer> {

	List<OrderedAdditionalProperty> getByRentalId(int rentalId);
}
