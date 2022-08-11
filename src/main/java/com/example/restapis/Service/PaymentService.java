package com.example.restapis.Service;

import com.example.restapis.Model.PaymentData;
import com.stripe.exception.StripeException;

public interface PaymentService {

    String savePayment(PaymentData paymentData,String date,String email) throws StripeException;
    String checkPayer(String email);
}
