package com.example.restapis.Repository;

import com.example.restapis.Model.PaymentData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PaymentDataRepository extends JpaRepository<PaymentData,String> {
}
