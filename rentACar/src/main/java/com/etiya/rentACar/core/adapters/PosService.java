package com.etiya.rentACar.core.adapters;

import com.etiya.rentACar.entities.CreditCard;
import org.springframework.stereotype.Service;

public interface PosService {

    Boolean makePayment(CreditCard creditCard);
}
