package org.example.student_management.controller;

import lombok.RequiredArgsConstructor;
import org.example.student_management.contract.UserService;
import org.example.student_management.dto.UserReadDto;
import org.example.student_management.dto.UserUpdateDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserReadDto>> getAllUsers(){
        return new ResponseEntity(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserReadDto> getUserById(@PathVariable("id") int id){
        return new ResponseEntity(userService.getUserById(id), HttpStatus.OK);
    }

    @PatchMapping("{id}")
    public ResponseEntity<UserReadDto> updateUser(@PathVariable("id") int id, @RequestBody UserUpdateDto userUpdateDto){
        return new ResponseEntity(userService.updateUser(id, userUpdateDto), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
        return new ResponseEntity("User deleted successfully", HttpStatus.OK);
    }
}
