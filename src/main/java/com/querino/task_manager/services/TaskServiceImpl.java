package com.querino.task_manager.services;

import com.querino.task_manager.models.Task;
import com.querino.task_manager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository repository;

    @Override
    public Task save(Task task) {
        return repository.save(task);
    }

    @Override
    public List<Task> findByUserId(Long id) {
        return repository.findByUserId(id);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
