package com.etiya.rentACar.business.requests.brandRequests;


import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBrandRequest {
	
	@JsonIgnore //Frontend kisminda id kismi gözükmez
	private int id;
	
	@NotNull//bos gecilmez
	@Length(min=1)//en az 1 karakter girilmeli
	private String name;
	
}
