package com.example.restapis.Controllers;

import com.example.restapis.Model.UserData;

import com.example.restapis.Service.LoginDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@ComponentScan(basePackages = {"com/example/restapis/Controllers"})
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    LoginDataServiceImpl loginDataService;

    @CrossOrigin
    @GetMapping("/loginData/{email}")
    public List<String> loginData(@PathVariable("email")String email){
      return loginDataService.findLoginData(email);
    }

    @CrossOrigin
    @PostMapping("/logincheck")
    public String check(@RequestBody UserData userData){

       Authentication authentication = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userData.getEmail(),userData.getPassword()));
       if(authentication.isAuthenticated()){
           return "Success";
       }
       else{
           return "Bad Credentials";
       }
    }

}
