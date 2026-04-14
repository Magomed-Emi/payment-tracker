package com.emi.paymenttracker.repository;

import com.emi.paymenttracker.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import com.emi.paymenttracker.entity.Payment;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Long>{

    boolean existsByTitleAndAmount(String title, BigDecimal amount);

    List<Payment> findByAmountGreaterThan(BigDecimal amount);

    List<Payment> findByAmountLessThan(BigDecimal amount);

    // requete JPQL
    @Query("SELECT MAX(p.amount) FROM Payment p")
    BigDecimal findMaxAmount();
    @Query("SELECT MIN(p.amount) FROM Payment p")
    BigDecimal findMinAmount();

    @Query("SELECT AVG(p.amount) FROM Payment p")
    BigDecimal findAvgAmount();


}


