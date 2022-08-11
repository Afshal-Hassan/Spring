package com.example.restapis.Controllers;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan(basePackages ="com/example/restapis/Controllers" )
public class TokenController {

    @CrossOrigin
    @GetMapping("/token")
    public CsrfToken csrf(CsrfToken token) {
        return token;
    }
}
