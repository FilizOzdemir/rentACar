package com.etiya.rentACar.core.crossCuttingConcerns.exceptionHandling;

@SuppressWarnings("serial")
public class BusinessException extends RuntimeException{

	//Çalışma anında olan hata
	
	public BusinessException(String message) {
		super(message);//Hata mesajı verme
	}
	
}
