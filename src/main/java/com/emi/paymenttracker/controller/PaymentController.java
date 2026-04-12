package com.emi.paymenttracker.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.emi.paymenttracker.service.PaymentService;
@RestController
@RequestMapping("Payment")


public class PaymentController {

    private PaymentService service;

    public PaymentController(PaymentService service)
    {
        this.service = service;
    }
    

}
