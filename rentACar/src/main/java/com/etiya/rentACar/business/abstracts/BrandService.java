package com.etiya.rentACar.business.abstracts;

import java.util.List;

import com.etiya.rentACar.business.requests.brandRequests.CreateBrandRequest;
import com.etiya.rentACar.business.requests.brandRequests.DeleteBrandRequest;
import com.etiya.rentACar.business.requests.brandRequests.UpdateBrandRequest;
import com.etiya.rentACar.business.responses.brandResponses.ListBrandDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

public interface BrandService {

	DataResult<List<ListBrandDto>> getAll();// tümünü getirir-listeler

	Result add(CreateBrandRequest createBrandRequest);// ekleme

	Result update(UpdateBrandRequest updateBrandRequest);// günceleme

	Result delete(DeleteBrandRequest deleteBrandRequest);// silme

}
