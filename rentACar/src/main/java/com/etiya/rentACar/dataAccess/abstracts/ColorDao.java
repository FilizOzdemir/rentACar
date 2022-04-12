package com.etiya.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etiya.rentACar.entities.Color;
@Repository //veri erişimi
public interface ColorDao extends JpaRepository<Color, Integer>{

	//IgnoreCase anahtar sözcüğü, sorgu eşleşmelerinin büyük/küçük harfe duyarlı olmamasını sağlar!!!
	//Bununla birlikte aynı ismi büyük yada kücük harfle iki kez girmemis olurum
	
	
	Boolean existsColorByNameIgnoreCase(String name);
	
	
}
