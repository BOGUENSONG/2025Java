
// 클라이언트 요청을 받고, 처리결과를 응답하는 클래스
// 비즈니스 로직은 Service가 처리
package com.example.demo.controller;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import com.example.demo.dto.UserDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/users")  // Day4 이 어노테이션을 추가하면 기본적으로 API 경로에 /users가 기본적으로 붙음.
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){ // @PathVariable은 요청 URL경로에서 값을 추출하여 메서드 파라미터로 전달해주는 역할 ( URL 파라미터 )
        return userService.getUserById(id);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDto dto, BindingResult result) {
        if (result.hasErrors()){
            return ResponseEntity.badRequest().body(result.getAllErrors()); //Day 6 검증실패 시 400 Error + 에러메시지 보내기
        }
        User createdUser = userService.createUser(dto);
        return ResponseEntity.ok(createdUser); // Day6 ResponseEntity ( 응답을 좀 더 간단하게 수정할 수 있는 함수 )
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody UserDto dto){ // path variable : URL 파라미터, RequestBody : Body
        return userService.updateUser(id,dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
