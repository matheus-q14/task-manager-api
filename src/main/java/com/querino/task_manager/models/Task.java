package com.querino.task_manager.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "tarefas")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    private String nome;
    private String descricao;
    private LocalDate dataCriacao;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User usuario;
}
