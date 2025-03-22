package com.querino.task_manager.repository;

import com.querino.task_manager.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query(value = "SELECT * FROM Task WHERE user_id = :userId", nativeQuery = true)
    List<Task> findByUserId(@Param("userId") Long userId);
}
