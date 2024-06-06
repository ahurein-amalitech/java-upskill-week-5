package org.example.student_management.contract;

import org.example.student_management.dto.UserReadDto;
import org.example.student_management.dto.UserUpdateDto;

import java.util.List;

public interface UserService {
    List<UserReadDto> getAllUsers();
    UserReadDto getUserById(int id);
    UserReadDto updateUser(int id, UserUpdateDto userUpdateDto);
    void deleteUser(int id);
}
