package com.etiya.rentACar.business.requests.colorRequests;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateColorRequest {
	@JsonIgnore
	private int id;
	
	//@NotNull
	//@Length(min=2)
	private String name;
}
