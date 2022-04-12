package com.etiya.rentACar.core.utilities.results;

public class ErrorResult extends Result {
	//yaptıgımız işlemin basarili olmama durumunda/false durumunda
	
	public ErrorResult() {
		super(false);
	}
	public ErrorResult(String message) {
		super(false,message);
	}
}
