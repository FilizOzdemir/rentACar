package com.etiya.rentACar.business.concretes;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.etiya.rentACar.business.abstracts.InvoiceService;
import com.etiya.rentACar.business.abstracts.OrderedAdditionalPropertyService;
import com.etiya.rentACar.business.abstracts.PaymentService;
import com.etiya.rentACar.business.abstracts.RentalService;
import com.etiya.rentACar.business.requests.paymentRequests.CreatePaymentRequest;
import com.etiya.rentACar.business.requests.paymentRequests.DeletePaymentRequest;
import com.etiya.rentACar.business.requests.paymentRequests.UpdatePaymentRequest;

import com.etiya.rentACar.business.responses.paymentResponses.ListPaymentDto;

import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.dataAccess.abstracts.PaymentDao;

import com.etiya.rentACar.entities.Payment;


@Service
public class PaymentManager implements PaymentService {

	private PaymentDao paymentDao;
	private ModelMapperService modelMapperService;
	private RentalService rentalService;
	private OrderedAdditionalPropertyService orderedAdditionalPropertyService;
	private InvoiceService invoiceService;
	private RentalService additionalPropertyService;


	@Override
	public Result add(CreatePaymentRequest createPaymentRequest) {
		return null;
	}

	@Override
	public Result delete(DeletePaymentRequest deletePaymentRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(UpdatePaymentRequest updatePaymentRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<ListPaymentDto>> getAll() {
		List<Payment> result =paymentDao.findAll();
		List<ListPaymentDto> response = result.stream().map(payment->modelMapperService.forDto().map(payment, ListPaymentDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<ListPaymentDto>>(response);
	}


	public void setPaymentDao(PaymentDao paymentDao) {
		this.paymentDao = paymentDao;
	}

	public void setModelMapperService(ModelMapperService modelMapperService) {
		this.modelMapperService = modelMapperService;
	}

	public void setRentalService(RentalService rentalService) {
		this.rentalService = rentalService;
	}
}
