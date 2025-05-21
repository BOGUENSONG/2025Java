package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final PayService payService;

    @Autowired
    public OrderService(PayService payService){
        this.payService = payService;
    }

    public String checkout(int amount){
        return payService.pay(amount);
    }
}
