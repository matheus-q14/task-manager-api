package com.querino.task_manager.services;

import com.querino.task_manager.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User user);

    List<User> findAll();

    Optional<User> findById(Long id);

    void deleteById(Long id);
}
