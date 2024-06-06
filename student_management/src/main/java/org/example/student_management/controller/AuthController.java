package org.example.student_management.controller;

import lombok.RequiredArgsConstructor;
import org.example.student_management.contract.AuthenticationService;
import org.example.student_management.dto.CreateUserDto;
import org.example.student_management.dto.SignInDto;
import org.example.student_management.dto.SuccessfulLoginResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService  authService;

    @PostMapping("/register")
    public ResponseEntity<SuccessfulLoginResponseDto> register(@RequestBody CreateUserDto request){
        return ResponseEntity.ok(authService.register(request));
    }


    @PostMapping("/login")
    public ResponseEntity<SuccessfulLoginResponseDto> register(@RequestBody SignInDto request){
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
