package com.querino.task_manager.services;

import com.querino.task_manager.dtos.TaskCreateDto;
import com.querino.task_manager.dtos.TaskResponseDto;

import java.util.List;

public interface TaskService {

    TaskResponseDto save(Long userId, TaskCreateDto taskCreateDto);

    List<TaskResponseDto> findAll();

    List<TaskResponseDto> findByUserId(Long id);

    TaskResponseDto findById(Long id);

    void deleteById(Long id);
}
