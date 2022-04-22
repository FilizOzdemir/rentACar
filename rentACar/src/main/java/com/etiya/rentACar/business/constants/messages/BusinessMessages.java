package com.etiya.rentACar.business.constants.messages;

public class BusinessMessages {

	public class MaintenanceMessages {
		//BAKIM MESAJLARI
		public static final String CAR_UNDERMAINTENANCE = "CAR_UNDERMAINTENANCE";
		public static final String MAINTENANCE_ADDED = "MAINTENANCE_ADDED";
        public static final String MAINTENANCE_DELETED = "MAINTENANCE_DELETED";
        public static final String MAINTENANCE_UPDATED = "MAINTENANCE_UPDATED";
	}
        public class RentalMessages {
        	//KİRALAMA MESAJLARI
            public static final String CAR_RENTED = "CAR_RENTED";
            public static final String CAR_NOT_AVAILABLE = "CAR_NOT_AVAILABLE";
            public static final String RENTAL_RETURNED = "RENTAL_RETURNED";
            public static final String RENTAL_ADDED = "RENTAL_ADDED";
            public static final String RENTAL_DELETED = "RENTAL_DELETED";
            public static final String RENTAL_UPDATED = "RENTAL_UPDATED";
            public static final String RENTAL_NOT_EXIST = "RENTAL_NOT_EXIST";
        }

        public class CityMessages {
        	//ŞEHİR MESAJLARI
            public static final String CITY_ADDED = "CITY_ADDED";
            public static final String CITY_DELETED = "CITY_DELETED";
            public static final String CITY_UPDATED = "CITY_UPDATED";
            public static final String CITY_NAME_EXISTS = "CITY_NAME_EXISTS";
            
        }

        public class BrandMessages {
        	//MARKA MESAJLARI
            public static final String BRAND_EXIST = "BRAND_EXIST";
            public static final String BRAND_ADDED = "BRAND_ADDED";
            public static final String BRAND_UPDATED = "BRAND_UPDATED";
            public static final String BRAND_DELETED = "BRAND_DELETED";
        }

        public class ColorMessages {
        	//RENK MESAJLARI
            public static final String COLOR_EXIST = "COLOR_EXIST";
            public static final String COLOR_ADDED = "COLOR_ADDED";
            public static final String COLOR_UPDATED = "COLOR_UPDATED";
            public static final String COLOR_DELETED = "COLOR_DELETED";
        }

        public class AdditionalPropertyMessages {
        	//EK ÖZELLİK-HİZMET MESAJLARI
            public static final String ADDITIONAL_PROPERTY_ADDED = "ADDITIONAL_PROPERTY_ADDED";
            public static final String ADDITIONAL_PROPERTY_DELETED = "ADDITIONAL_PROPERTY_DELETED";
            public static final String ADDITIONAL_PROPERTY_UPDATED = "ADDITIONAL_PROPERTY_UPDATED";
        }

        public class CarMessages {
        	//ARABA MESAJLARI
            public static final String CAR_ADDED = "CAR_ADDED";
            public static final String CAR_DELETED = "CAR_DELETED";
            public static final String CAR_UPDATED = "CAR_UPDATED";
            public static final String CAR_NOT_AVAILABLE = "CAR_NOT_AVAILABLE";
            public static final String CAR_STATE_UPDATED = "CAR_STATE_UPDATED";
        }

        public class CustomerMessages{
        	//MÜŞTERİ MESAJLARI
            public static final String CUSTOMER_ADDED = " CUSTOMER_ADDED";
            public static final String CUSTOMER_UPDATED = "CUSTOMER_UPDATED";
            public static final String CUSTOMER_DELETED = "CUSTOMER_DELETED";
        }

        public class DamageMessages{
        	//HASAR MESAJLARI
            public static final String DAMAGE_ADDED = "DAMAGE_ADDED";
            public static final String DAMAGE_UPDATED = "DAMAGE_UPDATED";
            public static final String DAMAGE_DELETED = "DAMAGE_DELETED";
        }

        public class OrderedAdditionalPropertyMessages{
        	//EK ÖZELİK-HİZMET MESAJLARI
            public static final String OREDERED_ADDITIONAL_PROPERTY_ADDED = "OREDERED_ADDITIONAL_PROPERTY_ADDED";
            public static final String OREDERED_ADDITIONAL_PROPERTY_DELETED = "OREDERED_ADDITIONAL_PROPERTY_DELETED";
            public static final String OREDERED_ADDITIONAL_PROPERTY_UPDATED = "OREDERED_ADDITIONAL_PROPERTY_UPDATED";
        }
        public class InvoiceMessages{
        	//FATURA MESAJLARI
            public static final String INVOICE_ADDED = "INVOICE_ADDED";
            public static final String INVOICE_DELETED = "INVOICE_DELETED";
            public static final String INVOICE_UPDATED = "INVOICE_UPDATED";
        }
        
        public class PaymentMessages{
        	//ÖDEME MESAJLARI
        	public static final String PAYMENT_ADDED ="PAYMENT_ADDED";
        	public static final String PAYMENT_DELETED="PAYMENT_DELETED";
        	public static final String PAYMENT_UPDATED = "PAYMENT_UPDATED";
        	public static final String PAYMENT_ERROR = "PAYMENT_ERROR";
            public static final String PAYMENT_CARD_IS_INVALID="PAYMENT_CARD_IS_INVALID";
        }
	
}
