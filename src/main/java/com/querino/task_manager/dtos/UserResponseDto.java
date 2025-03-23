package com.querino.task_manager.dtos;

import java.util.List;

public record UserResponseDto(Long id, String nome, String email, List<String> tarefas) {
}
