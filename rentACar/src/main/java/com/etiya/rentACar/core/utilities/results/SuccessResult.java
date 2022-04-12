package com.etiya.rentACar.core.utilities.results;

public class SuccessResult extends Result{

	//yaptıgımız işlemin basarili olma durumunda/true durumunda
	
	public SuccessResult() {
		super(true);
	}
	public SuccessResult(String message) {
		super(true,message);
	}
}
