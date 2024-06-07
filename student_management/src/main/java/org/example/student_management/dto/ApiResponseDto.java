package org.example.student_management.dto;

import lombok.*;
import lombok.Data;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseDto<T> {
    private String message;
}