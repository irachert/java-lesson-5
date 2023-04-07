package com.example.lesson_5;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class UserController {
    List<ResponseUserDTO> users = new ArrayList<>();

    @PostMapping("/user")
    public ResponseEntity<ResponseUserDTO> createUser(@Validated @RequestBody CreateUserDTO userData) {
        UUID id = UserService.nextUUID();
        ResponseUserDTO newUser = new ResponseUserDTO(userData,id);
        users.add(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @PostMapping("/users")
    public ResponseEntity<List<ResponseUserDTO>> createUsers(@RequestBody @Validated ArrayList<CreateUserDTO> usersListData) {
        List<ResponseUserDTO> newUsers = new ArrayList<>();
        for(CreateUserDTO userData:usersListData){
            UUID id = UserService.nextUUID();
            ResponseUserDTO newUser = new ResponseUserDTO(userData,id);
            newUsers.add(newUser);
        }
        users.addAll(newUsers);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUsers);
    }

    @GetMapping("/all-users")
    public ResponseEntity<List<ResponseUserDTO>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<ResponseUserDTO> getUser(@PathVariable String id) {
        ResponseUserDTO findUser = UserService.findUserById(id, users);
        if (findUser == null) {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(findUser);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<ResponseUserDTO> updateUser(
            @PathVariable String id,
            @Validated @RequestBody ResponseUserDTO userData) {
        ResponseUserDTO  updatedUser = UserService.updateUser(id, users, userData);
        if (updatedUser == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable String id) {
        Boolean deletedUser = UserService.deleteUser(id, users);
        if (deletedUser == false) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
        }
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }
}