package com.example.restapis.Repository;


import com.example.restapis.Model.UserData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<UserData,String> {


    @Query(value = "select ud.name,ud.email,ud.country,ud.signUpDate from UserData ud where ud.userType =:Shipper")
    List<String> findAllShipper(@Param("Shipper")String userType);
    @Query("select ud.email from UserData ud where ud.email =:e")
    String findEmail(@Param("e")String email);

    UserData findByName(String name);
    UserData findByEmailAndPassword(String email,String password);
    UserData findByEmail(String email);

    @Query("select ud.userType from UserData ud where ud.email =:e")
    String findUserType(@Param("e")String email);

    @Query("select ud.signUpDate from UserData ud where ud.email =:e")
    String findSubscriptionDate(@Param("e")String email);
    @Modifying
    @Query(value = "update UserData set signUpDate =:spdate where email =:e")
    void updateSubscription(@Param("spdate")String date,@Param("e")String email);





}
