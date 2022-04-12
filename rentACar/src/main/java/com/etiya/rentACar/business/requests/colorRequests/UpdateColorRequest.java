package com.etiya.rentACar.business.requests.colorRequests;
import org.hibernate.validator.constraints.Length;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateColorRequest {

	private int id;
	
	//@NotNull
	@Length(min=2)
	private String name;

	
}
