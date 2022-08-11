package com.example.restapis.Model;


import org.hibernate.annotations.Where;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "User_Data")
public class UserData {



    private String name;



    @Id
    private String email;
    private String password;
    private String country;



    private String phoneNo;

    @Column(name = "user_type")
    private String userType;

    private String signUpDate;



    public UserData() {
        this.name=null;
        this.email=null;
        this.password=null;
        this.country=null;
        this.phoneNo=null;
    }

    public UserData(String name, String email, String password, String country, String phoneNo) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.country = country;
        this.phoneNo = phoneNo;
    }

    public String getSignUpDate() {
        return signUpDate;
    }

    public void setSignUpDate(String signUpDate) {
        this.signUpDate = signUpDate;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCountry() {
        return country;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", country='" + country + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserData userData = (UserData) o;
        return Objects.equals(name, userData.name) && Objects.equals(email, userData.email) && Objects.equals(password, userData.password) && Objects.equals(country, userData.country) && Objects.equals(phoneNo, userData.phoneNo);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, email, password, country, phoneNo);
    }





}
