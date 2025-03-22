package com.querino.task_manager.services;

import com.querino.task_manager.models.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    Task save(Task task);

    List<Task> findByUserId(Long id);

    Optional<Task> findById(Long id);

    void deleteById(Long id);
}
