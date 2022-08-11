package com.example.restapis.Service;

import com.example.restapis.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;

@Service
public class LoginDataServiceImpl implements LoginDataService{

    @Autowired
    UserRepository userRepository;

    @Override
    public List<String> findLoginData(String email) {
        String findedEmail= userRepository.findEmail(email);
        String userType= userRepository.findUserType(email);
        String subscriptionDate=userRepository.findSubscriptionDate(email);
       return Arrays.asList(findedEmail,userType,subscriptionDate);

    }
}
