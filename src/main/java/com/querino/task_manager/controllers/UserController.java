package com.querino.task_manager.controllers;

import com.querino.task_manager.dtos.UserCreateDto;
import com.querino.task_manager.dtos.UserResponseDto;
import com.querino.task_manager.services.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @Operation(summary = "Obter todos os usuários")
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    @Operation(summary = "Obter usuário por ID")
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findById(userId));
    }

    @Operation(summary = "Criar usuário")
    @PostMapping
    public ResponseEntity<UserResponseDto> create(@RequestBody UserCreateDto userCreateDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userCreateDto));
    }

    @Operation(summary = "Deletar usuário por ID")
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteById(@PathVariable Long userId) {
        userService.deleteById(userId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
