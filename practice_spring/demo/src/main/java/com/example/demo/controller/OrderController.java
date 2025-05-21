package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.*;

@RestController // RestController를 써도되고, 그냥 Controller를 써도 됨. 그저 명시하는 것 뿐임 이 클래스는 REST APi를 구현한다! 이런 뜻임.
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("/checkout")
    public String checkout(){
        String ret = orderService.checkout(10000); //만원으로 가정함. 원래 RequestBody로 받아야하지만
        return ret + "결재 완료!";
    }



}
