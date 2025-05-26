package com.example.demo.service;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.domain.*;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired // 생성자가 1개면 Spring 2.6부터는 자동으로 주입해주기때문에 Autowired를 명시 안해줘도되긴함.
    public UserService (UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){ // 1. 유저 리스트 가져오기 READ
        return userRepository.findAll();
    }

    public User createUser(User user){ // 2. 유저 추가하기 Create
        return userRepository.save(user);
    }

    public User updateUser(Long id, User updatedUser){ // 3. 유저 수정하기 Update
        User user = userRepository.findById(id).orElseThrow( () -> new RuntimeException("User not Found") );
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        return userRepository.save(user);
    }

    public void deleteUser(Long id){ // 4. 유저 삭제하기
        userRepository.deleteById(id);
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow( () -> new RuntimeException("User not Found!") );
    }

}
