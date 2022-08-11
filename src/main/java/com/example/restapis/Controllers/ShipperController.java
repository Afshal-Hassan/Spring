package com.example.restapis.Controllers;

import com.example.restapis.Service.ShipperServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ComponentScan(basePackages = "com/example/restapis/Controllers")
public class ShipperController {

    @Autowired
    ShipperServiceImpl shipperService;

    @CrossOrigin
    @GetMapping("/getallshippers/{userType}")
    public List<String> getAllShippers(@PathVariable("userType")String userType){
         return shipperService.getAllShipper(userType);
    }
}
