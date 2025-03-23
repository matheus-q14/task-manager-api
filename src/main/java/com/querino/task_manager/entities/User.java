package com.querino.task_manager.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "usuarios")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @NonNull
    private String nome;
    @NonNull
    private String email;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Task> tasks;

    public List<String> getNomeTarefas() {
        List<String> nomeTarefas = new ArrayList<>();
        try {
            tasks.forEach(t -> nomeTarefas.add(t.getNome()));
            return nomeTarefas;
        } catch (Exception e) {
            return nomeTarefas;
        }
    }
}
