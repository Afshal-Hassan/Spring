package com.example.restapis.Service;

import com.example.restapis.Model.PaymentData;

import com.example.restapis.Model.UserData;
import com.example.restapis.Repository.PaymentDataRepository;
import com.example.restapis.Repository.UserRepository;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import com.stripe.Stripe;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Value("${stripe.apikey}")
    String stripekey;

    @Autowired
    PaymentDataRepository paymentDataRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public String savePayment(PaymentData paymentData,String date,String email) throws StripeException {
        Stripe.apiKey=stripekey;
        Map<String, Object> params = new HashMap<>();
        params.put("name", paymentData.getName());
        params.put("email", paymentData.getEmail());
        Customer customer = Customer.create(params);
        paymentData.setCustomerId(customer.getId());
        paymentDataRepository.save(paymentData);
        userRepository.updateSubscription(date,email);
        return "Successfully Paid";
    }

    @Override
    public String checkPayer(String email) {
        UserData userData=userRepository.findByEmail(email);
        if(userData==null){
            return "User Not Found";
        }
        else{
            return "User Found";
        }
    }
}
