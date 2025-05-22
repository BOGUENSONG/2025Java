package com.example.demo.controller;
// 클라이언트 요청을 받고, 처리결과를 응답하는 클래스
// 비즈니스 로직은 Service가 처리

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/users")  // 이 어노테이션을 추가하면 기본적으로 API 경로에 /users가 기본적으로 붙음.
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("users/{id}")
    public User getUser(@PathVariable Long id){ // @PathVariable은 요청 URL경로에서 값을 추출하여 메서드 파라미터로 전달해주는 역할 ( URL 파라미터 )
        return userService.getUserById(id);
    }
}
