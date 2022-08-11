package com.example.restapis.Controllers;


import com.example.restapis.Model.PaymentData;

import com.example.restapis.Repository.UserRepository;

import com.example.restapis.Service.PaymentServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.ComponentScan;

import org.springframework.web.bind.annotation.*;

import com.stripe.exception.StripeException;




@RestController
@ComponentScan(basePackages ="com/example/restapis/Controllers" )
public class PaymentController {

   @Autowired
    PaymentServiceImpl paymentService;

   @Autowired
    UserRepository userRepository;


    @CrossOrigin
    @PostMapping("/payment/{date}/{email}")
    public String payment(@RequestBody PaymentData paymentData,@PathVariable("date")String date, @PathVariable("email") String email) throws StripeException {
        return paymentService.savePayment(paymentData,date,email);
    }

    @CrossOrigin
    @GetMapping("/checkPayer/{email}")
    public String checkPayer(@PathVariable("email")String email){
        return paymentService.checkPayer(email);


    }
}
