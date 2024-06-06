package org.example.student_management.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.student_management.entity.Role;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDto {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Role role;
}

