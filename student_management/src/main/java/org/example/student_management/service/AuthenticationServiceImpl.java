package org.example.student_management.service;

import lombok.RequiredArgsConstructor;
import org.example.student_management.contract.AuthenticationService;
import org.example.student_management.contract.JwtService;
import org.example.student_management.contract.UserRepository;
import org.example.student_management.dto.CreateUserDto;
import org.example.student_management.dto.SignInDto;
import org.example.student_management.dto.SuccessfulLoginResponseDto;
import org.example.student_management.entity.Role;
import org.example.student_management.entity.User;
import org.example.student_management.exceptions.UserNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;

    @Override
    public SuccessfulLoginResponseDto register(CreateUserDto request) {
        var userExist = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UserNotFoundException());

        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.User)
                .build();

        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return SuccessfulLoginResponseDto.builder()
                .token(jwtToken)
                .message("Account created successfully")
                .build();
    }

    @Override
    public SuccessfulLoginResponseDto authenticate(SignInDto request) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = repository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return SuccessfulLoginResponseDto.builder()
                .token(jwtToken)
                .message("Login successful")
                .build();
    }
}
