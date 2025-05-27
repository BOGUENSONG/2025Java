package com.example.demo.dto;

// Day 5 DTO 추가
public class UserDto {

    private String name;
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
