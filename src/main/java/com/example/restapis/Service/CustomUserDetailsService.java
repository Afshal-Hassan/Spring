package com.example.restapis.Service;

import com.example.restapis.Model.CustomUserDetails;
import com.example.restapis.Model.UserData;
import com.example.restapis.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    UserData userData;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        userData=this.userRepository.findByEmail(email);
        if(userData==null){

           throw  new UsernameNotFoundException("Not Found");
        }

        return new CustomUserDetails(userData);


    }
}
