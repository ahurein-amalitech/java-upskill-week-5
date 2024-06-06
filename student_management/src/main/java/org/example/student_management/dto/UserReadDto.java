package org.example.student_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.student_management.entity.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReadDto {
    private String email;
    private String firstName;
    private String lastName;
    private Role role;
}
