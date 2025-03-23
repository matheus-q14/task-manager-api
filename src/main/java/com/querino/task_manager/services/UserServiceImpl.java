package com.querino.task_manager.services;

import com.querino.task_manager.dtos.UserCreateDto;
import com.querino.task_manager.dtos.UserResponseDto;
import com.querino.task_manager.entities.User;
import com.querino.task_manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserResponseDto save(UserCreateDto userDto) {
        User user = new User(userDto.nome(), userDto.email());
        repository.save(user);
        return new UserResponseDto(user.getUserId(), user.getNome(), user.getEmail(), user.getNomeTarefas());
    }

    @Override
    public List<UserResponseDto> findAll() {
        List<User> users = repository.findAll();
        List<UserResponseDto> userResponse = new ArrayList<>();
        users.forEach(user -> userResponse.add(new UserResponseDto(
                user.getUserId(),
                user.getNome(),
                user.getEmail(),
                user.getNomeTarefas()
        )));
        return userResponse;
    }

    @Override
    public UserResponseDto findById(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        UserResponseDto userResponse = new UserResponseDto(
                user.getUserId(),
                user.getNome(),
                user.getEmail(),
                user.getNomeTarefas()
        );
        return userResponse;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
