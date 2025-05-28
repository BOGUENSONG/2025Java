package com.example.demo.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

// Day 5 DTO 추가
public class UserDto {

    @NotBlank(message = "이름은 필수입니다.")
    private String name;
    @Email(message = "올바른 이메일 형식을 입력하세요.")
    private String email;

    public UserDto(){}
    public UserDto(String name, String email){
        this.name = name;
        this.email = email;
    }

    //GETTER

    public String getName() {
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    //SETTER

    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }



}
