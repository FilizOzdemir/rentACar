package com.etiya.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.etiya.rentACar.business.abstracts.OrderedAdditionalPropertyService;
import com.etiya.rentACar.business.constants.messages.BusinessMessages;
import com.etiya.rentACar.business.requests.orderedAdditionalPropertyRequets.CreateOrderedAdditionalPropertyRequest;
import com.etiya.rentACar.business.requests.orderedAdditionalPropertyRequets.DeleteOrderedAdditionalPropertyRequest;
import com.etiya.rentACar.business.requests.orderedAdditionalPropertyRequets.UpdateOrderedAdditionalPropertyRequest;
import com.etiya.rentACar.business.responses.orderedAdditionalPropertyResponses.ListOrderedAdditionalPropertyDto;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.OrderedAdditionalPropertyDao;
import com.etiya.rentACar.entities.OrderedAdditionalProperty;

@Service
public class OrderedAdditionalPropertyManager implements OrderedAdditionalPropertyService{

	private OrderedAdditionalPropertyDao orderedAdditionalPropertyDao;
	private ModelMapperService modelMapperService;
	
	public OrderedAdditionalPropertyManager(OrderedAdditionalPropertyDao orderedAdditionalPropertyDao,
			ModelMapperService modelMapperService) {
		
		this.orderedAdditionalPropertyDao = orderedAdditionalPropertyDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateOrderedAdditionalPropertyRequest createOrderedAdditionalPropertyRequest) {
		OrderedAdditionalProperty result = this.modelMapperService.forRequest()
				.map(createOrderedAdditionalPropertyRequest, OrderedAdditionalProperty.class);
		this.orderedAdditionalPropertyDao.save(result);
		return new SuccessResult(BusinessMessages.OrderedAdditionalPropertyMessages.OREDERED_ADDITIONAL_PROPERTY_ADDED);
	}

	@Override
	public Result update(UpdateOrderedAdditionalPropertyRequest updateOrderedAdditionalPropertyRequest) {
		OrderedAdditionalProperty result = this.modelMapperService.forRequest()
				.map(updateOrderedAdditionalPropertyRequest, OrderedAdditionalProperty.class);
		this.orderedAdditionalPropertyDao.save(result);
		return new SuccessResult(BusinessMessages.OrderedAdditionalPropertyMessages.OREDERED_ADDITIONAL_PROPERTY_UPDATED);
	}

	@Override
	public Result delete(DeleteOrderedAdditionalPropertyRequest deleteOrderedAdditionalPropertyRequest) {
		int orderedAdditionalPropertyId =deleteOrderedAdditionalPropertyRequest.getId();
		this.orderedAdditionalPropertyDao.deleteById(orderedAdditionalPropertyId);
		return new SuccessResult(BusinessMessages.OrderedAdditionalPropertyMessages.OREDERED_ADDITIONAL_PROPERTY_DELETED);
	}

	@Override
	public DataResult<List<ListOrderedAdditionalPropertyDto>> getAll() {
	List<OrderedAdditionalProperty> results = this.orderedAdditionalPropertyDao.findAll();
	List<ListOrderedAdditionalPropertyDto> response = results.stream().map(OrderedAdditionalProperty -> modelMapperService.forDto()
			.map(OrderedAdditionalProperty, ListOrderedAdditionalPropertyDto.class))
			.collect(Collectors.toList());
	return new SuccessDataResult<List<ListOrderedAdditionalPropertyDto>>(response);
	}

	@Override
	public void CreateOrderedAdditionalProperty(int rentalId, List<Integer> additionalPropertiesId) {
		CreateOrderedAdditionalPropertyRequest createOrderedAdditionalPropertyRequest = new CreateOrderedAdditionalPropertyRequest();
		for(int additionalPropertyId: additionalPropertiesId) {
			createOrderedAdditionalPropertyRequest.setRentalId(rentalId);
			createOrderedAdditionalPropertyRequest.setAdditionalPropertyId(additionalPropertyId);
			this.add(createOrderedAdditionalPropertyRequest);
		}	
	}
}
