package com.etiya.rentACar.business.abstracts;

import java.util.List;

import com.etiya.rentACar.business.requests.rentalRequests.CreateRentalRequest;
import com.etiya.rentACar.business.requests.rentalRequests.DeleteRentalRequest;
import com.etiya.rentACar.business.requests.rentalRequests.ReturnRentalRequest;
import com.etiya.rentACar.business.requests.rentalRequests.UpdateRentalRequest;
import com.etiya.rentACar.business.responses.rentalResponses.ListRentalDto;
import com.etiya.rentACar.business.responses.rentalResponses.RentalDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

public interface RentalService {
	
	DataResult<List<ListRentalDto>> getAll();

	Result add(CreateRentalRequest createRentalRequest);

	Result update(UpdateRentalRequest updateRentalRequest);

	Result delete(DeleteRentalRequest deleteRentalRequest);

	Result returnRental(ReturnRentalRequest returnRentalRequest);//dönüş kiralama
	
	RentalDto getById(int rentalId);
	
}
