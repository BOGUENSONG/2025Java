package com.example.demo.service;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.domain.*;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService (UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow( () -> new RuntimeException("User not Found!") );
    }

}
