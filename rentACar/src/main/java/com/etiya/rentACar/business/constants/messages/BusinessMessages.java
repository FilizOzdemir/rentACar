package com.etiya.rentACar.business.constants.messages;

public class BusinessMessages {

	public class MaintenanceMessages {
		//BAKIM MESAJLARI
		public static final String CAR_UNDERMAINTENANCE = "Bakıma Almak İstediğiniz Araç Zaten Şu Anda Bakımda !";
		public static final String MAINTENANCE_ADDED = "Araç Bakım Ekleme İşlemi Başarıyla Gerçekleşti !";
        public static final String MAINTENANCE_DELETED = "Araç Bakım Silme İşlemi Başarıyla Gerçekleşti !";
        public static final String MAINTENANCE_UPDATED = "Araç Bakım Güncelleme İşlemi Başarıyla Gerçekleşti !";
	}
        public class RentalMessages {
        	//KİRALAMA MESAJLARI
            public static final String CAR_RENTED = "Bu Araç Kirada !";
            public static final String CAR_NOT_AVAILABLE = " Araç Kiralanmak İçin Müsait Değil !";
            public static final String RENTAL_RETURNED = "Kiralanan Araç Başarıyla Teslim Alınmıştır !";
            public static final String RENTAL_ADDED = "Kiralama Başarıyla Eklenmiştir !";
            public static final String RENTAL_DELETED = "Kiralama Kaydı Silinmiştir !";
            public static final String RENTAL_UPDATED = "Kiralama Kaydı Güncellenmiştir !";
            public static final String RENTAL_NOT_EXIST = "Böyle bir id ile daha önce bir kiralanma işlemi yoktur. Dolayısıyla teslim alınma söz konusu olamaz !";
        }

        public class CityMessages {
        	//ŞEHİR MESAJLARI
            public static final String CITY_ADDED = "Şehir Eklendi !";
            public static final String CITY_DELETED = "Şehir Silme İşlemi Başarıyla Gerçekleşmiştir !";
            public static final String CITY_UPDATED = "Şehir Güncelleme İşlemi Başarıyla Gerçekleşmiştir !";
            public static final String CITY_NAME_EXISTS = "Girdiğiniz Şehir Mevcuur !";
            
        }

        public class BrandMessages {
        	//MARKA MESAJLARI
            public static final String BRAND_EXIST = " Girdiğiniz Marka Mevcuttur !";
            public static final String BRAND_ADDED = "Marka Ekleme İşlemi Başarıyla Gerçekleşti !";
            public static final String BRAND_UPDATED = "Marka Güncelleme İşlemi Başarılya Gerçekleşti 1";
            public static final String BRAND_DELETED = "Marka Başarıyla Silindi !";
        }

        public class ColorMessages {
        	//RENK MESAJLARI
            public static final String COLOR_EXIST = " Girdiğiniz Renk Mevcuttur !";
            public static final String COLOR_ADDED = "Renk Ekleme İşlemi Başarıyla Gerçekleşti !";
            public static final String COLOR_UPDATED = "Renk Güncelleme işlemi Başarıya Gerçekleşti !";
            public static final String COLOR_DELETED = "Renk Silme İşlemi Başarıyla Gerçekleşti !";
        }

        public class AdditionalPropertyMessages {
        	//EK ÖZELLİK-HİZMET MESAJLARI
            public static final String ADDITIONAL_PROPERTY_ADDED = "Ek Hizmetler Ekleme İşlemi Başarıyla Gerçekleşti !";
            public static final String ADDITIONAL_PROPERTY_DELETED = "Ek Hizmetler Başaryıla Silindi !";
            public static final String ADDITIONAL_PROPERTY_UPDATED = "Ek Hizmelter Başarıyla Güncellendi !";
        }

        public class CarMessages {
        	//ARABA MESAJLARI
            public static final String CAR_ADDED = "Başarıyla Eklendi !";
            public static final String CAR_DELETED = "Başarıyla Silindi !";
            public static final String CAR_UPDATED = "Başarıyla Güncellendi !";
            public static final String CAR_NOT_AVAILABLE = "Böyle Bir Araba Mevcut Değil !";
            public static final String CAR_STATE_UPDATED = "Araba Durumu Güncellemesi Başarıyla Gerçekleşti !";
        }

        public class CustomerMessages{
        	//MÜŞTERİ MESAJLARI
            public static final String CUSTOMER_ADDED = " Müşteri Başarıyla Eklendi !";
            public static final String CUSTOMER_UPDATED = "Müşteri Güncelleme İşlemi Başarıyla Gerçekleşti !";
            public static final String CUSTOMER_DELETED = "Müşteri Silme İşlemi Başarıyla Gerçekleşti !";
        }

        public class DamageMessages{
        	//HASAR MESAJLARI
            public static final String DAMAGE_ADDED = "Hasar Ekleme İşlemi Başarıyla Gerçekleşti !";
            public static final String DAMAGE_UPDATED = "Hasar Güncelleme İşlemi Başarıyla Gerçekleşti !";
            public static final String DAMAGE_DELETED = "Hasar Silme İşlemi Başarıyla Gerçekleşti !";
        }

        public class OrderedAdditionalPropertyMessages{
        	//EK ÖZELİK-HİZMET MESAJLARI
            public static final String OREDERED_ADDITIONAL_PROPERTY_ADDED = "Ek Hizmetler Siparişi Başarıyla Eklendi !";
            public static final String OREDERED_ADDITIONAL_PROPERTY_DELETED = "Ek Hizmetler Siparişi Başarıyla Silindi !";
            public static final String OREDERED_ADDITIONAL_PROPERTY_UPDATED = "Ek Hizmetler Siparişi Başarıyla Güncellendi !";
        }
        public class InvoiceMessages{
        	//FATURA MESAJLARI
            public static final String INVOICE_ADDED = "Fatura Başarıyla Eklendi !";
            public static final String INVOICE_DELETED = "Fatura Başarıyla Silindi !";
            public static final String INVOICE_UPDATED = "Fatura Başarıyla Güncellendi !";
        }
        
        public class PaymentMessages{
        	//ÖDEME MESAJLARI
        	public static final String PAYMENT_ADDED ="Ödeme Başarıyla Eklendi !";
        	public static final String PAYMENT_DELETED="Ödeme Başarıyla Silindi !";
        	public static final String PAYMENT_UPDATED = "Ödeme Başarıyla Güncellendi !";
        	public static final String PAYMENT_ERROR = "Banka Ödeme İşlemini Onaylamadı !";
            public static final String PAYMENT_CARD_IS_INVALID="Kar Geçersiz !";
        }
	
}
