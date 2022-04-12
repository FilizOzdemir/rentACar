package com.etiya.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.etiya.rentACar.business.abstracts.CityService;
import com.etiya.rentACar.business.constants.messages.BusinessMessages;
import com.etiya.rentACar.business.requests.cityRequests.CreateCityRequest;
import com.etiya.rentACar.business.requests.cityRequests.DeleteCityRequest;
import com.etiya.rentACar.business.requests.cityRequests.UpdateCityRequest;
import com.etiya.rentACar.business.responses.cityResponses.ListCityDto;
import com.etiya.rentACar.core.crossCuttingConcerns.exceptionHandling.BusinessException;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.CityDao;
import com.etiya.rentACar.entities.City;

@Service
public class CityManager implements CityService {

	private CityDao cityDao;
	private ModelMapperService modelMapperService;
	
	public CityManager(CityDao cityDao, ModelMapperService modelMapperService) {
		this.cityDao = cityDao;
		this.modelMapperService = modelMapperService;
	}
	
	@Override
	public Result add(CreateCityRequest createCityRequest) {
		
		checkIfCityExists(createCityRequest.getName());
		City city = this.modelMapperService.forRequest().map(createCityRequest, City.class);//mapleme
		this.cityDao.save(city);
		return new SuccessResult(BusinessMessages.CityMessages.CITY_ADDED);//şehir eklendi
	}

	@Override
	public Result update(UpdateCityRequest updateCityRequest) {
		City city = this.modelMapperService.forRequest().map(updateCityRequest, City.class);
		this.cityDao.save(city);
		return new SuccessResult(BusinessMessages.CityMessages.CITY_UPDATED);//şehir güncellendi
	}

	@Override
	public Result delete(DeleteCityRequest deleteCityRequest) {
		int cityId = deleteCityRequest.getId();
		this.cityDao.deleteById(cityId);
		return new SuccessResult(BusinessMessages.CityMessages.CITY_DELETED);//şehir silindi
	}
	@Override
	public DataResult<List<ListCityDto>> getAll() {
		List<City> cities=this.cityDao.findAll();
		List<ListCityDto> response=cities.stream().map(city -> this.modelMapperService.forDto().map(city, ListCityDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<ListCityDto>>(response);
	}


	public void checkIfCityExists(String cityName) {
		if(this.cityDao.getByNameIgnoreCase(cityName).size()!=0) {
			throw new BusinessException(BusinessMessages.CityMessages.CITY_NAME_EXISTS);//girdiginiz şehir mevcut mesajı verır.
		}
		
	}
}
