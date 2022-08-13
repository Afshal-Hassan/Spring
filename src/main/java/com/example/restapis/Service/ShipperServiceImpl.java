package com.example.restapis.Service;
import com.example.restapis.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Service
public class ShipperServiceImpl implements ShipperService{

    @Autowired
    UserRepository userRepository;


    @Override
    public List<String> getAllShipper(String userType)throws IndexOutOfBoundsException {
        List<String> shipperData = userRepository.findAllShipper(userType);
        if(shipperData.isEmpty()){
          return Arrays.asList("Shipper is not present") ;
      }
      return userRepository.findAllShipper(userType);
    }

    @Override
    public List<String> findShipper(String email,String userType) {
        List<String>shipper=userRepository.findShipper(email,userType);
        if(shipper.isEmpty()){
            return Arrays.asList("Not Found");
        }
        else{
            return userRepository.findShipper(email,userType);
        }
    }
}
