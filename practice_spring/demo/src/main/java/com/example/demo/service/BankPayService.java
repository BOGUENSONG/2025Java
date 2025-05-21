package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class BankPayService implements PayService{
    @Override
    public String pay(int amount) {
        String ret = "[Bank]계좌이체로" + amount + "원 결제 합니다.\n";
        System.out.println(ret);
        return ret;
    }
}
