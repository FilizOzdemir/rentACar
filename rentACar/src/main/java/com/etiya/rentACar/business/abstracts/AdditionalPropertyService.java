package com.etiya.rentACar.business.abstracts;

import java.util.List;

import com.etiya.rentACar.business.requests.additionalPropertyRequests.CreateAdditionalPropertyRequest;
import com.etiya.rentACar.business.requests.additionalPropertyRequests.DeleteAdditionalPropertyRequest;
import com.etiya.rentACar.business.requests.additionalPropertyRequests.UpdateAdditionalPropertyRequest;
import com.etiya.rentACar.business.responses.additionalPropertyResponses.AdditionalPropertyDto;
import com.etiya.rentACar.business.responses.additionalPropertyResponses.ListAdditionalPropertyDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

public interface AdditionalPropertyService {

	DataResult<List<ListAdditionalPropertyDto>> getAll();// tümünü listeleme

	Result add(CreateAdditionalPropertyRequest createAdditionalPropertyRequest);// ekleme

	Result update(UpdateAdditionalPropertyRequest updateAdditionalPropertyRequest);// güncelleme

	Result delete(DeleteAdditionalPropertyRequest deleteAdditionalPropertyRequest);// silme

	DataResult<AdditionalPropertyDto> getById(int id);
}
