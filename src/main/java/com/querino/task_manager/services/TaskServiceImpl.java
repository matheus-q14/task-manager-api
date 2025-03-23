package com.querino.task_manager.services;

import com.querino.task_manager.dtos.TaskCreateDto;
import com.querino.task_manager.dtos.TaskResponseDto;
import com.querino.task_manager.entities.Task;
import com.querino.task_manager.entities.User;
import com.querino.task_manager.repository.TaskRepository;
import com.querino.task_manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public TaskResponseDto save(Long userId, TaskCreateDto taskCreateDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Task task = new Task(taskCreateDto.nome(), taskCreateDto.descricao(), LocalDate.now(), user);
        taskRepository.save(task);
        return new TaskResponseDto(
                task.getTaskId(),
                task.getNome(),
                task.getDescricao(),
                task.getDataCriacao(),
                task.getUsuario().getNome());
    }

    @Override
    public List<TaskResponseDto> findAll() {
        List<Task> tarefas = taskRepository.findAll();
        List<TaskResponseDto> taskResponse = new ArrayList<>();
        tarefas.forEach(t -> taskResponse.add(new TaskResponseDto(
                t.getTaskId(),
                t.getNome(),
                t.getDescricao(),
                t.getDataCriacao(),
                t.getUsuario().getNome()
        )));
        return taskResponse;
    }

    @Override
    public List<TaskResponseDto> findByUserId(Long id) {
        List<Task> tarefas = taskRepository.findByUserId(id);
        List<TaskResponseDto> taskResponse = new ArrayList<>();
        tarefas.forEach(t -> taskResponse.add(new TaskResponseDto(
                t.getTaskId(),
                t.getNome(),
                t.getDescricao(),
                t.getDataCriacao(),
                t.getUsuario().getNome()
        )));
        return taskResponse;
    }

    @Override
    public TaskResponseDto findById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        TaskResponseDto taskResponse = new TaskResponseDto(
                task.getTaskId(),
                task.getNome(),
                task.getDescricao(),
                task.getDataCriacao(),
                task.getUsuario().getNome()
        );
        return taskResponse;
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }
}
