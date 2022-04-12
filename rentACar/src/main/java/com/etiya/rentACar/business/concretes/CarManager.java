package com.etiya.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.etiya.rentACar.business.abstracts.CarService;
import com.etiya.rentACar.business.constants.messages.BusinessMessages;
import com.etiya.rentACar.business.requests.carRequests.CreateCarRequest;
import com.etiya.rentACar.business.requests.carRequests.DeleteCarRequest;
import com.etiya.rentACar.business.requests.carRequests.UpdateCarCityRequest;
import com.etiya.rentACar.business.requests.carRequests.UpdateCarRequest;
import com.etiya.rentACar.business.requests.carRequests.UpdateCarStateRequest;
import com.etiya.rentACar.business.requests.carRequests.UpdateKilometerRequest;
import com.etiya.rentACar.business.responses.carResponses.CarDto;
import com.etiya.rentACar.business.responses.carResponses.ListCarDto;

import com.etiya.rentACar.core.crossCuttingConcerns.exceptionHandling.BusinessException;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.CarDao;
import com.etiya.rentACar.entities.Car;
import com.etiya.rentACar.entities.CarStates;


@Service
public class CarManager implements CarService {

	private CarDao carDao;
	private ModelMapperService modelMapperService;

	public CarManager(CarDao carDao, ModelMapperService modelMapperService) {
		this.carDao = carDao;
		this.modelMapperService = modelMapperService;

	}

	@Override
	public Result add(CreateCarRequest createCarRequest) {
		
		checkIfCarAvailable(createCarRequest.getId());
		Car car = this.modelMapperService.forRequest().map(createCarRequest, Car.class);
		this.carDao.save(car);
		return new SuccessResult(BusinessMessages.CarMessages.CAR_ADDED);// araba eklendi
	}

	@Override
	public Result update(UpdateCarRequest updateCarRequest) {

		Car car = this.modelMapperService.forRequest().map(updateCarRequest, Car.class);
		this.carDao.save(car);
		return new SuccessResult(BusinessMessages.CarMessages.CAR_UPDATED);// araba güncellendi
	}

	@Override
	public Result delete(DeleteCarRequest deleteCarRequest) {

		int carId = deleteCarRequest.getId();
		this.carDao.deleteById(carId);
		return new SuccessResult(BusinessMessages.CarMessages.CAR_DELETED);// araba silindi
	}

	@Override
	public DataResult<List<ListCarDto>> getAll() {
		List<Car> cars = this.carDao.findAll();
		List<ListCarDto> response = cars.stream()
				.map(car -> this.modelMapperService.forDto().map(car, ListCarDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<ListCarDto>>(response);
	}

	@Override
	public CarDto getById(int id) {// id getirme
		Car car = this.carDao.getById(id);
		CarDto response = this.modelMapperService.forDto().map(car, CarDto.class);
		return response;
	}

	@Override
	public CarDto getByCarId(int carId) {// car id getirme
		Car car = this.carDao.getById(carId);
		CarDto response = this.modelMapperService.forDto().map(car, CarDto.class);
		return response;
	}

	@Override
	public DataResult<List<ListCarDto>> getAllByModelYear(double modelYear) {
		List<Car> cars = this.carDao.getByModelYear(modelYear);
		List<ListCarDto> response = cars.stream()
				.map(car -> this.modelMapperService.forDto().map(car, ListCarDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<ListCarDto>>(response);
	}

	@Override
	public DataResult<List<ListCarDto>> getAllPaged(int pageNo, int pageSize) {// sayfalama

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		List<Car> cars = this.carDao.findAll(pageable).getContent();
		List<ListCarDto> response = cars.stream()
				.map(car -> this.modelMapperService.forDto().map(car, ListCarDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<ListCarDto>>(response);
	}

	@Override
	public DataResult<List<ListCarDto>> getAllSorted() {// siralama

		Sort sort = Sort.by(Sort.Direction.DESC, "modelYear");
		List<Car> cars = this.carDao.findAll(sort);
		List<ListCarDto> response = cars.stream()
				.map(car -> this.modelMapperService.forDto().map(car, ListCarDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<ListCarDto>>(response);
	}

	@Override
	public void checkIfCarAvailable(int id) {// aracın Mevcut Olup Olmadıgını Kontrol Etme

		Car car = carDao.getById(id);
		if (car.getCarState() == CarStates.UnderMaintenance || car.getCarState() == CarStates.Rented) {
																										 
			throw new BusinessException(BusinessMessages.CarMessages.CAR_NOT_AVAILABLE);// mevcut degil mesajı yazar
		}

	}

	@Override
	public Result updateCarState(UpdateCarStateRequest updateCarStateRequest) {
		int carId = updateCarStateRequest.getCarId();
		Car car = this.carDao.getById(carId);
		UpdateCarRequest response = modelMapperService.forRequest().map(car, UpdateCarRequest.class);
		response.setId(carId);
		response.setCarStateName(updateCarStateRequest.getCarStateName());
		Car result = this.modelMapperService.forRequest().map(response, Car.class);
		this.carDao.save(result);
		return new SuccessResult(BusinessMessages.CarMessages.CAR_STATE_UPDATED);
	}

	@Override
	public void updateCarKilometer(UpdateKilometerRequest updateKilometerRequest) {
		int carId = updateKilometerRequest.getId();
		Car car = this.carDao.getById(carId);
		UpdateCarRequest updateCarRequest = this.modelMapperService.forRequest().map(car, UpdateCarRequest.class);
		updateCarRequest.setKilometer(updateKilometerRequest.getKilometer());
		Car result = this.modelMapperService.forRequest().map(updateCarRequest, Car.class);
		this.carDao.save(result);

	}

	@Override
	public void updateCarCity(UpdateCarCityRequest updateCarCityRequest) {
		int carId = updateCarCityRequest.getId();
		Car car = this.carDao.getById(carId);
		UpdateCarRequest updateCarRequest = this.modelMapperService.forRequest().map(car, UpdateCarRequest.class);
		updateCarRequest.setCityId(updateCarCityRequest.getCityId());
		Car result = this.modelMapperService.forRequest().map(updateCarRequest, Car.class);
		this.carDao.save(result);

	}

}
