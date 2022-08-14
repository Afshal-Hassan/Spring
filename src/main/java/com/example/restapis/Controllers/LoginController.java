package com.example.restapis.Controllers;
import com.example.restapis.Service.CustomUserDetailsService;
import com.example.restapis.Service.LoginDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@ComponentScan(basePackages = {"com/example/restapis/Controllers"})
public class LoginController {

    @Autowired
    LoginDataServiceImpl loginDataService;

    @CrossOrigin
    @GetMapping("/loginData/{email}")
    public List<String> loginData(@PathVariable("email")String email){
      return loginDataService.findLoginData(email);
    }



}
