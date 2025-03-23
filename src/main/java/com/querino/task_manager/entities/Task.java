package com.querino.task_manager.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tarefas")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;
    @NonNull
    private String nome;
    @NonNull
    private String descricao;
    @NonNull
    private LocalDate dataCriacao;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @NonNull
    private User usuario;

}
