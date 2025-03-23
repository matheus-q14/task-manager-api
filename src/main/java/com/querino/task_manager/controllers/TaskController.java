package com.querino.task_manager.controllers;

import com.querino.task_manager.dtos.TaskCreateDto;
import com.querino.task_manager.dtos.TaskResponseDto;
import com.querino.task_manager.services.TaskServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskServiceImpl taskService;

    @Operation(summary = "Obter todas as tarefas")
    @GetMapping
    public ResponseEntity<List<TaskResponseDto>> getAllTasks() {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findAll());
    }

    @Operation(summary = "Obter tarefa por Id")
    @GetMapping("/{taskId}")
    public ResponseEntity<TaskResponseDto> findById(@PathVariable Long taskId) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findById(taskId));
    }

    @Operation(summary = "Obter tarefa por Id de usuário")
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TaskResponseDto>> findByUserId(@PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findByUserId(userId));
    }

    @Operation(summary = "Criar tarefa")
    @PostMapping("/user/{userId}")
    public ResponseEntity<TaskResponseDto> createTask(@PathVariable Long userId, @RequestBody TaskCreateDto taskCreateDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.save(userId, taskCreateDto));
    }

    @Operation(summary = "Deletar tarefa por ID")
    @DeleteMapping("/{taskId}")
    public ResponseEntity<?> deleteTaskById(@PathVariable Long taskId) {
        taskService.deleteById(taskId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
