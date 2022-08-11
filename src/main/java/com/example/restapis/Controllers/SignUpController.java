package com.example.restapis.Controllers;

import java.lang.String;

import com.example.restapis.Model.UserData;
import com.example.restapis.Repository.UserRepository;
import org.aspectj.weaver.bcel.BcelAccessForInlineMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@ComponentScan(basePackages = {"com/example/restapis/Controllers"})
public class SignUpController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;



    @CrossOrigin
    @RequestMapping(value = "/signup/{email}",method = RequestMethod.POST)
    public String saveUserData(@PathVariable("email") String email,@RequestBody UserData userData){

        UserData user = userRepository.findByEmail(email);
        String password=userData.getPassword();
        userData.setPassword(bCryptPasswordEncoder.encode(password));
        if(user==null){
            System.out.println("Hello");
            userRepository.save(userData);
            System.out.println("Your Data is saved");
            return "Your data is saved";
        }
        else{
            System.out.println("Email already exists");
            return "Email already exists";

        }


    }


}
