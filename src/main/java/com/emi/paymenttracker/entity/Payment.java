package com.emi.paymenttracker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import java.math.BigDecimal;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private BigDecimal amount;

    public Payment(){

    }
    public Payment(String title,BigDecimal amount)
    {
        this.title = title;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setAmount(BigDecimal montant) {
        this.amount = montant;
    }

    public BigDecimal getAmount()
    {
        return amount;
    }


}



