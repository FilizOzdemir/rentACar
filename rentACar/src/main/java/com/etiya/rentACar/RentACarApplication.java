package com.etiya.rentACar;

import java.util.HashMap;

import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.etiya.rentACar.core.crossCuttingConcerns.exceptionHandling.BusinessException;
import com.etiya.rentACar.core.utilities.results.ErrorDataResult;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;;

@SpringBootApplication // anotasyonu uygulamanın giriş metodunu belirtir. Uygulama bu metod ile başlar.
@RestControllerAdvice
public class RentACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);
	}

	@Bean// Bean: Yeniden kullanılabilir obje 
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
	//Uygulamada bir hata olursa bunun tüm uygulamada çalışması gerekir
	
	@ExceptionHandler //Hata yakalama
	@ResponseStatus(code= HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException){
		Map<String ,String> validationErrors = new HashMap<String,String>();
		for(FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errorDataResult = new ErrorDataResult<Object>(validationErrors,"VALIDATION_ERROR(S)");
		return errorDataResult;
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleBusinessException(BusinessException businessException){
		ErrorDataResult<Object> errorResults = new ErrorDataResult<>(businessException.getMessage(), "Business.Error");
		return errorResults;
	}

	
}
