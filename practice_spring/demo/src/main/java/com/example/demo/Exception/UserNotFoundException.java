package com.example.demo.Exception;

public class UserNotFoundException extends RuntimeException {
    
    public UserNotFoundException(String message){
        super(message); // 커스텀 예외 클래스
    }
}
