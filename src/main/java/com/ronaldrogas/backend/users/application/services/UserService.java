package com.ronaldrogas.backend.users.application.services;

import com.ronaldrogas.backend.users.domain.models.User;
import com.ronaldrogas.backend.users.domain.ports.input.UserUseCase;
import com.ronaldrogas.backend.users.domain.ports.output.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserUseCase {
    
    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User createUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        user.setId(id);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }
}
