package com.etiya.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.etiya.rentACar.business.abstracts.CarService;
import com.etiya.rentACar.business.abstracts.OrderedAdditionalPropertyService;
import com.etiya.rentACar.business.abstracts.RentalService;
import com.etiya.rentACar.business.constants.messages.BusinessMessages;

import com.etiya.rentACar.business.requests.carRequests.UpdateCarCityRequest;
import com.etiya.rentACar.business.requests.carRequests.UpdateCarStateRequest;
import com.etiya.rentACar.business.requests.carRequests.UpdateKilometerRequest;
import com.etiya.rentACar.business.requests.orderedAdditionalPropertyRequets.CreateOrderedAdditionalPropertyRequest;
import com.etiya.rentACar.business.requests.rentalRequests.CreateRentalRequest;
import com.etiya.rentACar.business.requests.rentalRequests.DeleteRentalRequest;
import com.etiya.rentACar.business.requests.rentalRequests.ReturnRentalRequest;
import com.etiya.rentACar.business.requests.rentalRequests.UpdateRentalRequest;
import com.etiya.rentACar.business.responses.carResponses.CarDto;
import com.etiya.rentACar.business.responses.rentalResponses.ListRentalDto;
import com.etiya.rentACar.business.responses.rentalResponses.RentalDto;
import com.etiya.rentACar.core.crossCuttingConcerns.exceptionHandling.BusinessException;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.RentalDao;
import com.etiya.rentACar.entities.CarStates;
import com.etiya.rentACar.entities.Rental;

@Service
public class RentalManager implements RentalService {
	private RentalDao rentalDao;
	private ModelMapperService modelMapperService;
	private CarService carService;
	private OrderedAdditionalPropertyService orderedAdditionalPropertyService;

	

	public RentalManager(RentalDao rentalDao, ModelMapperService modelMapperService, CarService carService,
			OrderedAdditionalPropertyService orderedAdditionalPropertyService) {
		this.rentalDao = rentalDao;
		this.modelMapperService = modelMapperService;
		this.carService = carService;
		this.orderedAdditionalPropertyService = orderedAdditionalPropertyService;
	}



	@Override
	public DataResult<List<ListRentalDto>> getAll() {
		List<Rental> results= this.rentalDao.findAll();//result=sonuc
		List<ListRentalDto> response = results.stream().map(rental -> modelMapperService.forDto().map(rental, ListRentalDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<ListRentalDto>>(response);
		
	}



	@Override
	public DataResult<Rental> add(CreateRentalRequest createRentalRequest) {
		int carId = createRentalRequest.getCarId();
	    checkIfCarState(carId);
	    
	    Rental result = this.modelMapperService.forRequest().map(createRentalRequest, Rental.class);
	    
	    CarDto car = this.carService.getById(carId);
	    result.setBeforeRentKilometer(car.getKilometer());
	    this.rentalDao.save(result);

		updateCarCity(carId,createRentalRequest.getReturnCityId());
		updateCarState(carId,CarStates.Rented);
		return new SuccessDataResult<Rental>(result,BusinessMessages.RentalMessages.RENTAL_ADDED);

	}

	@Override
	public Result update(UpdateRentalRequest updateRentalRequest) {
		Rental result=this.modelMapperService.forRequest().map(updateRentalRequest, Rental.class);
		this.rentalDao.save(result);
		return new SuccessResult(BusinessMessages.RentalMessages.RENTAL_UPDATED);
	}



	@Override
	public Result delete(DeleteRentalRequest deleteRentalRequest) {
		int rentalId= deleteRentalRequest.getId();
		this.rentalDao.deleteById(rentalId);
		return new SuccessResult(BusinessMessages.RentalMessages.RENTAL_DELETED);
	}



	@Override
	public Result returnRental(ReturnRentalRequest returnRentalRequest) {
		checkIfRentalIdExists(returnRentalRequest.getId());

		Rental result = this.rentalDao.getById(returnRentalRequest.getId());
		result.setReturnDate(returnRentalRequest.getReturnDate());
		result.setAfterRentKilometer(returnRentalRequest.getAfterRentKilometer());
		this.rentalDao.save(result);

		
		int carId = returnRentalRequest.getCarId();
		updateCarKilometer(carId, returnRentalRequest.getAfterRentKilometer());
		updateCarCity(carId, returnRentalRequest.getReturnCityId());
		updateCarState(carId,CarStates.Available);
		
		return new SuccessResult(BusinessMessages.RentalMessages.RENTAL_RETURNED);
	}


	@Override
	public RentalDto getById(int rentalId) {
		Rental rental = this.rentalDao.getById(rentalId);
		RentalDto rentalDto = this.modelMapperService.forDto().map(rental, RentalDto.class);
		return rentalDto;
	}

	public void updateCarKilometer(int carId, double carKilometer) {
		//kilometre güncellemesi

		UpdateKilometerRequest updateKilometerRequest=new UpdateKilometerRequest();
		updateKilometerRequest.setId(carId);
		updateKilometerRequest.setKilometer(carKilometer);
		this.carService.updateCarKilometer(updateKilometerRequest);
	}
	
	public void checkIfCarState(int carId) {//arabanın durumunu kontrol etme
		CarDto result=this.carService.getByCarId(carId);
		if(result.getCarStateName()!=CarStates.Available) {
			throw new BusinessException(BusinessMessages.RentalMessages.RENTAL_NOT_EXIST);
		}
	}
	
	public void checkIfRentalIdExists(int rentalId) {//rentalId kontrolü
		if(!this.rentalDao.existsById(rentalId)) {
			throw new BusinessException(BusinessMessages.RentalMessages.RENTAL_NOT_EXIST);
		}
	}
	public void updateCarState(int carId,CarStates states) {//araba durumunu güncelleme
		UpdateCarStateRequest updateCarStateRequest= new UpdateCarStateRequest();
		updateCarStateRequest.setCarId(carId);
		updateCarStateRequest.setCarStateName(states);
		this.carService.updateCarState(updateCarStateRequest);
	}
	
	public void updateCarCity(int carId,int cityId) {//(araba) şehir durumunu güncelleme
		UpdateCarCityRequest updateCarCityRequest= new UpdateCarCityRequest();
		updateCarCityRequest.setId(carId);
		updateCarCityRequest.setCityId(cityId);
		this.carService.updateCarCity(updateCarCityRequest);
	}
	
	public void createOrderedAdditionalProperty(int rentalId,List<Integer> additionalPropertiesId) {
		CreateOrderedAdditionalPropertyRequest createOrderedAdditionalPropertyRequest = new CreateOrderedAdditionalPropertyRequest();
		for(int additionalPropertyId : additionalPropertiesId) {
			createOrderedAdditionalPropertyRequest.setRentalId(rentalId);
			createOrderedAdditionalPropertyRequest.setAdditionalPropertyId(additionalPropertyId);
			this.orderedAdditionalPropertyService.add(createOrderedAdditionalPropertyRequest);
		}
	}

	
	
}
