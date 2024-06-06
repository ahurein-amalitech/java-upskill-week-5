package org.example.student_management.contract;

import org.example.student_management.dto.CreateUserDto;
import org.example.student_management.dto.SignInDto;
import org.example.student_management.dto.SuccessfulLoginResponseDto;

public interface AuthenticationService {
    SuccessfulLoginResponseDto register(CreateUserDto request);
    SuccessfulLoginResponseDto authenticate(SignInDto request);
}
