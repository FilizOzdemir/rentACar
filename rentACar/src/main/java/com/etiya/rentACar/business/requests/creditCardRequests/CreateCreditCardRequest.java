package com.etiya.rentACar.business.requests.creditCardRequests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCreditCardRequest {
   @JsonIgnore
    private int id;

    private String creditCardNumber;

    private String firstName;

    private String lastName;

    private String cvv;

    private String expirationDate;
}
