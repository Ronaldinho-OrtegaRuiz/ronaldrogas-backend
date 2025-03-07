package com.ronaldrogas.backend.users.infrastructure.persistence.adapters;

import com.ronaldrogas.backend.users.domain.models.User;
import com.ronaldrogas.backend.users.domain.ports.output.UserRepository;
import com.ronaldrogas.backend.users.infrastructure.persistence.mappers.UserMapper;
import com.ronaldrogas.backend.users.infrastructure.persistence.repositories.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PostgresUserRepository implements UserRepository {
    
    private final JpaUserRepository jpaUserRepository;
    private final UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return jpaUserRepository.findAll()
                .stream()
                .map(userMapper::toUser)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> findById(Long id) {
        return jpaUserRepository.findById(id)
                .map(userMapper::toUser);
    }

    @Override
    public User save(User user) {
        var entity = userMapper.toEntity(user);
        var savedEntity = jpaUserRepository.save(entity);
        return userMapper.toUser(savedEntity);
    }

    @Override
    public void deleteById(Long id) {
        jpaUserRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaUserRepository.existsById(id);
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpaUserRepository.existsByEmail(email);
    }
} 