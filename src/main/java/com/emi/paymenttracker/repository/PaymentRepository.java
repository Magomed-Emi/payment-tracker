package com.emi.paymenttracker.repository;

import com.emi.paymenttracker.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long>{

}


