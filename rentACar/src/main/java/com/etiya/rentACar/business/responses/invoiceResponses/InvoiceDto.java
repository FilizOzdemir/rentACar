package com.etiya.rentACar.business.responses.invoiceResponses;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto {

	private int id;
	private String invoiceNumber;//double mı olmalı?
	private LocalDate createDate;//oluşturma tarihi
	private LocalDate rentDate;//kira tarihi
	private LocalDate returnDate;//iade tarihi
	private int totalRentDay;//kiralama günü
	private double totalPrice;//toplam fiyat
	private String customerFirstName;
	private String customerLastName;
	
}
