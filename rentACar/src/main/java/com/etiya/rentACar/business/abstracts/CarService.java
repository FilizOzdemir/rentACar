package com.etiya.rentACar.business.abstracts;

import java.util.List;

import com.etiya.rentACar.business.requests.carRequests.CreateCarRequest;
import com.etiya.rentACar.business.requests.carRequests.DeleteCarRequest;
import com.etiya.rentACar.business.requests.carRequests.UpdateCarCityRequest;
import com.etiya.rentACar.business.requests.carRequests.UpdateCarRequest;
import com.etiya.rentACar.business.requests.carRequests.UpdateCarStateRequest;
import com.etiya.rentACar.business.requests.carRequests.UpdateKilometerRequest;
import com.etiya.rentACar.business.responses.carResponses.CarDto;
import com.etiya.rentACar.business.responses.carResponses.ListCarDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

public interface CarService {

	
	
	DataResult<List<ListCarDto>> getAll();// tümünü listeme

	DataResult<List<ListCarDto>> getAllByModelYear(double modelYear);// tüm arabalarin model yillarini listeme

	DataResult<List<ListCarDto>> getAllPaged(int pageNo, int pageSize);// hangi sayfa, bir sayfa da kaç tane olsun

	DataResult<List<ListCarDto>> getAllSorted();// siralama


	CarDto getById(int id);//tüm id'leri listeleme

	CarDto getByCarId(int carId);//getById

	
	Result add(CreateCarRequest createCarRequest);

	Result update(UpdateCarRequest updateCarRequest);

	Result delete(DeleteCarRequest deleteCarRequest);
	
	void updateCarState(UpdateCarStateRequest updateCarStateRequest);// araba durumu isteğini güncelleme kısmını listeleme
	
	void updateCarKilometer(UpdateKilometerRequest updateKilometerRequest);
	
	void updateCarCity(UpdateCarCityRequest updateCarCityRequest);

	

}
