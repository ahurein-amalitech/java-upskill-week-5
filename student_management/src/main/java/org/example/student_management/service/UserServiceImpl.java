package org.example.student_management.service;

import lombok.RequiredArgsConstructor;
import org.example.student_management.contract.UserRepository;
import org.example.student_management.contract.UserService;
import org.example.student_management.dto.UserReadDto;
import org.example.student_management.dto.UserUpdateDto;
import org.example.student_management.exceptions.UserNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<UserReadDto> getAllUsers() {
        var users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserReadDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserReadDto getUserById(int id) {
        var user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
        return this.modelMapper.map(user, UserReadDto.class);
    }

    @Override
    public UserReadDto updateUser(int id, UserUpdateDto userUpdateDto) {
        var existingUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
        this.modelMapper.map(userUpdateDto, existingUser);
        var updatedUser = userRepository.save(existingUser);
        return this.modelMapper.map(updatedUser, UserReadDto.class);
    }

    @Override
    public void deleteUser(int id) {
        var user = userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException());
        userRepository.delete(user);
    }
}
