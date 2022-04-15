package com.etiya.rentACar.business.requests.colorRequests;
import org.hibernate.validator.constraints.Length;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateColorRequest {

	private int id;

	private String name;

	
}
