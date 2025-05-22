package com.example.demo.domain;

import jakarta.persistence.*;


@Entity // 이 클래스가 DB테이블과 매핑되는 JPA 엔터티 임을 명시. 이 클래스는 user 테이블과 연결되는거야!
@Table(name = "app_user") // DB가 없어 h2 Db쓰는데 H2에서는 User가 예약어라서 app_user로 테이블명을 따로 명시해주어야함.
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // INSERT 시 id값을 자동으로 올려주는 것. MySQL의 auto_increment처럼 DB에 맡김
    private Long id;
    private String name;
    private String email;

    public User() {}

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
    //GETTER가 없으면 DB에서 데이터 못가져옴.
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
}
