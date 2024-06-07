package org.example.student_management.dto;

import lombok.*;
import org.example.student_management.entity.Role;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDto {
    private String password;
    private String firstName;
    private String lastName;
    private Role role;
}
