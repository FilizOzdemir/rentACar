package com.etiya.rentACar.business.abstracts;

import java.util.List;

import com.etiya.rentACar.business.requests.paymentRequests.CreatePaymentRequest;
import com.etiya.rentACar.business.requests.paymentRequests.DeletePaymentRequest;
import com.etiya.rentACar.business.requests.paymentRequests.UpdatePaymentRequest;
import com.etiya.rentACar.business.responses.paymentResponses.ListPaymentDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

public interface PaymentService {

	Result add(CreatePaymentRequest createPaymentRequest);
	Result delete(DeletePaymentRequest deletePaymentRequest);
	Result update(UpdatePaymentRequest updatePaymentRequest);
	DataResult<List<ListPaymentDto>> getAll();
}
