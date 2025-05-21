package com.example.demo.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary // 이번 예제에서만 특별히 사용자로부터 어떤 Pay를 선택하는지 만들지 않았기 때문에 Card를 주 서비스로 지정해서 OrderService에서 자동으로 주입되도록 설정.
@Service
public class CardPayService implements PayService{
    @Override
    public String pay(int amount) {
        String ret = "[card] I pay" + amount + "won \n";
        System.out.println(ret);
        return ret;
    }
}
