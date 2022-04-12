package com.etiya.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etiya.rentACar.entities.AdditionalProperty;

@Repository
public interface AdditionalPropertyDao extends JpaRepository<AdditionalProperty, Integer>{

	List<AdditionalProperty> getAllById(int id); 
	AdditionalProperty getById(int id);
}
