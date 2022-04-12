package com.etiya.rentACar.business.abstracts;

import java.util.List;

import com.etiya.rentACar.business.requests.orderedAdditionalPropertyRequets.CreateOrderedAdditionalPropertyRequest;
import com.etiya.rentACar.business.requests.orderedAdditionalPropertyRequets.DeleteOrderedAdditionalPropertyRequest;
import com.etiya.rentACar.business.requests.orderedAdditionalPropertyRequets.UpdateOrderedAdditionalPropertyRequest;
import com.etiya.rentACar.business.responses.orderedAdditionalPropertyResponses.ListOrderedAdditionalPropertyDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

public interface OrderedAdditionalPropertyService {

	Result add(CreateOrderedAdditionalPropertyRequest createOrderedAdditionalPropertyRequest);
	Result update(UpdateOrderedAdditionalPropertyRequest updateOrderedAdditionalPropertyRequest);
	Result delete(DeleteOrderedAdditionalPropertyRequest deleteOrderedAdditionalPropertyRequest);
	
	DataResult<List<ListOrderedAdditionalPropertyDto>> getAll();
	
	void CreateOrderedAdditionalProperty(int rentalId, List<Integer> additionalPropertiesId);
}
