package com.etiya.rentACar.core.utilities.results;

public class Result {

	private boolean success;//işlem basarili mi değil mi ?
	private String message;//başarili olan mesaj basarisiz olan mesaj
	
	public Result(boolean success) {
		this.success=success;
	}
	public Result(boolean success, String message) {
		this(success);
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public String getMessage() {
		return message;
	}
	
	
	
}
