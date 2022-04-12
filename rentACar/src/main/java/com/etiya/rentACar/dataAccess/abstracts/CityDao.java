package com.etiya.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etiya.rentACar.entities.City;

@Repository
public interface CityDao extends JpaRepository<City, Integer> {

	City getById(int id);
	//Boolean existsCityByNameIgnoreCase(String name);
	List<City> getByNameIgnoreCase(String name);//bu kısıma bak!!!
}
