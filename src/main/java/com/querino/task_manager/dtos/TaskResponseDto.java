package com.querino.task_manager.dtos;

import java.time.LocalDate;

public record TaskResponseDto(Long id, String nome, String descricao, LocalDate dataCriacao, String usuario) {
}
