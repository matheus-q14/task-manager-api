package com.querino.task_manager.repository;

import com.querino.task_manager.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
