package com.etiya.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etiya.rentACar.entities.Car;

@Repository
public interface CarDao extends JpaRepository<Car, Integer> {

	List<Car> getByModelYear(double modelYear);
	List<Car> getByModelYearIn(List<Double> modelYears);//model yıllarını verir
	List<Car> getByModelYearAndDailyPrice(double modelYear,double dailyPrice);//model yılı ve günlük fıyatı şu kadar olan aracı lısteler
	List<Car> getByDescriptionContains(String description);//acıklama kısmını listeler
	
	List<Car> getByCityId(int id );//şehir id lerini kismini listeler
	List<Car> getAllByCity(String city );
	
	Car getById(int id);//ekledim
}
