package com.querino.task_manager.services;

import com.querino.task_manager.dtos.UserCreateDto;
import com.querino.task_manager.dtos.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto save(UserCreateDto userDto);

    List<UserResponseDto> findAll();

    UserResponseDto findById(Long id);

    void deleteById(Long id);
}
