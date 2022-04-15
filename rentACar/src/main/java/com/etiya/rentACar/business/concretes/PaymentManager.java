package com.etiya.rentACar.business.concretes;

import java.time.Period;
import java.util.List;

import java.util.Objects;
import java.util.stream.Collectors;

import com.etiya.rentACar.business.abstracts.*;
import com.etiya.rentACar.business.constants.messages.BusinessMessages;
import com.etiya.rentACar.business.requests.invoiceRequests.CreateInvoiceRequest;
import com.etiya.rentACar.business.requests.orderedAdditionalPropertyRequets.CreateOrderedAdditionalPropertyRequest;
import com.etiya.rentACar.core.adapters.PosService;
import com.etiya.rentACar.core.crossCuttingConcerns.exceptionHandling.BusinessException;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.entities.*;
import org.springframework.stereotype.Service;

import com.etiya.rentACar.business.requests.paymentRequests.CreatePaymentRequest;
import com.etiya.rentACar.business.requests.paymentRequests.DeletePaymentRequest;
import com.etiya.rentACar.business.requests.paymentRequests.UpdatePaymentRequest;

import com.etiya.rentACar.business.responses.paymentResponses.ListPaymentDto;

import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.dataAccess.abstracts.PaymentDao;


@Service
public class PaymentManager implements PaymentService {

	private PaymentDao paymentDao;
	private ModelMapperService modelMapperService;
	private RentalService rentalService;
	private OrderedAdditionalPropertyService orderedAdditionalPropertyService;
	private InvoiceService invoiceService;
	private AdditionalPropertyService additionalPropertyService;
	private CustomerService customerService;
	private PosService posService;

	public PaymentManager(PaymentDao paymentDao, ModelMapperService modelMapperService, RentalService rentalService
			, OrderedAdditionalPropertyService orderedAdditionalPropertyService, InvoiceService invoiceService
			, AdditionalPropertyService additionalPropertyService, CustomerService customerService, PosService posService) {
		this.paymentDao = paymentDao;
		this.modelMapperService = modelMapperService;
		this.rentalService = rentalService;
		this.orderedAdditionalPropertyService = orderedAdditionalPropertyService;
		this.invoiceService = invoiceService;
		this.additionalPropertyService = additionalPropertyService;
		this.customerService = customerService;
		this.posService = posService;
	}

	@Override
	public Result add(CreatePaymentRequest createPaymentRequest) {
		this.checkIfCreditCard(createPaymentRequest);

		Payment result = this.modelMapperService.forRequest().map(createPaymentRequest, Payment.class);

		//Rental Service-Araç Ekleme
		Rental rental = this.rentalService.add(createPaymentRequest.getCreateRentalRequest()).getData();
		//Ordered Service-Ek Hizmetler Ekleme
		this.orderedAdditionalAddService(createPaymentRequest, rental.getId());
		//TotalPrice-Toplam Fiyat
		calculateTotalPrice(createPaymentRequest);
		//Customer Service -Müsteri Ekleme
		Customer customer = this.customerService.getById(createPaymentRequest.getCustomerId()).getData();
		//Invoice Service-Fatura Ekleme
		Invoice invoice = this.invoiceAddService(createPaymentRequest, rental.getId(),customer.getId());

		//paymentAdd
		result.setTotalPrice(calculateTotalPrice(createPaymentRequest));
		result.setInvoice(invoice);
		result.setCustomer(customer);
		result.setRental(rental);
		this.paymentDao.save(result);

		return  new SuccessResult(BusinessMessages.PaymentMessages.PAYMENT_ADDED);
	}

	@Override
	public Result update(UpdatePaymentRequest updatePaymentRequest) {
		Payment payment=this.modelMapperService.forRequest().map(updatePaymentRequest, Payment.class);
		this.paymentDao.save(payment);
		return new SuccessResult(BusinessMessages.PaymentMessages.PAYMENT_UPDATED);
	}

	@Override
	public Result delete(DeletePaymentRequest deletePaymentRequest) {
		int paymentId= deletePaymentRequest.getId();
		this.paymentDao.deleteById(paymentId);
		return new SuccessResult(BusinessMessages.PaymentMessages.PAYMENT_DELETED);
	}



	@Override
	public DataResult<List<ListPaymentDto>> getAll() {
		List<Payment> result = paymentDao.findAll();
		List<ListPaymentDto> response = result.stream().map(payment -> modelMapperService.forDto().map(payment, ListPaymentDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<ListPaymentDto>>(response);
	}


	private void orderedAdditionalAddService(CreatePaymentRequest createPaymentRequest,int id){
		for(CreateOrderedAdditionalPropertyRequest createOrderedAdditionalPropertyRequest : createPaymentRequest.getCreateOrderedAdditionalPropertyRequest()){
			createOrderedAdditionalPropertyRequest.setRentalId(id);
			this.orderedAdditionalPropertyService.add(createOrderedAdditionalPropertyRequest);
		}
	}

	private Invoice invoiceAddService(CreatePaymentRequest createPaymentRequest, int rentalId, int customerId){
		CreateInvoiceRequest createInvoiceRequest = createPaymentRequest.getCreateInvoiceRequest();
		createInvoiceRequest.setRentalId(rentalId);
		createInvoiceRequest.setCustomerId(customerId);
		createInvoiceRequest.setTotalPrice(calculateTotalPrice(createPaymentRequest));
		return invoiceService.add(createInvoiceRequest).getData();
	}

	private double calculateTotalPrice(CreatePaymentRequest createPaymentRequest){
		List<Integer> additionalPropertyId = createPaymentRequest.getCreateOrderedAdditionalPropertyRequest()
				.stream().map(CreateOrderedAdditionalPropertyRequest::getAdditionalPropertyId).collect(Collectors.toList());

		double totalPrice = 0;

		Period day = Period.between(createPaymentRequest.getCreateRentalRequest().getRentDate(), createPaymentRequest.getCreateRentalRequest().getReturnDate());

		int daysCount = day.getDays();

		if (!Objects.equals(createPaymentRequest.getCreateRentalRequest().getReturnCityId(), createPaymentRequest.getCreateRentalRequest().getRentCityId())) {
			totalPrice += 750;
		}

		totalPrice += createPaymentRequest.getCreateRentalRequest().getDailyPrice() * daysCount;

		for (Integer additionalproperty : additionalPropertyId) {
			totalPrice += this.additionalPropertyService.getById(additionalproperty).getData().getDailyPrice() * daysCount;
		}

		return totalPrice;
	}

	private void checkIfCreditCard(CreatePaymentRequest createPaymentRequest) {
		CreditCard creditCard = new CreditCard();
		creditCard.setCreditCardNumber(createPaymentRequest.getCreditCard().getCreditCardNumber());
		creditCard.setCvv(createPaymentRequest.getCreditCard().getCvv());
		creditCard.setExpirationDate(createPaymentRequest.getCreditCard().getExpirationDate());
		if (!this.posService.makePayment(creditCard)){
			throw new BusinessException(BusinessMessages.PaymentMessages.PAYMENT_CARD_IS_INVALID);//kart geçersiz!
		}
	}


}
