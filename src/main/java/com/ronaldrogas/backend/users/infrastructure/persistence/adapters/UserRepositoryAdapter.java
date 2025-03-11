package com.ronaldrogas.backend.users.infrastructure.persistence.adapters;

import com.ronaldrogas.backend.users.domain.models.User;
import com.ronaldrogas.backend.users.domain.ports.output.UserRepository;
import com.ronaldrogas.backend.users.infrastructure.persistence.entities.UserEntity;
import com.ronaldrogas.backend.users.infrastructure.persistence.mappers.UserMapper;
import com.ronaldrogas.backend.users.infrastructure.persistence.repositories.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepository {

    private final JpaUserRepository jpaUserRepository;
    private final UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return jpaUserRepository.findAll().stream()
                .map(userMapper::toUser)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> findById(Long id) {
        return jpaUserRepository.findById(id).map(userMapper::toUser);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return jpaUserRepository.findByEmail(email).map(userMapper::toUser);
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = userMapper.toEntity(user);
        if (userEntity.getAddresses() != null) {
            userEntity.getAddresses().forEach(address -> address.setUser(userEntity));
        }
        if (userEntity.getPhones() != null) {
            userEntity.getPhones().forEach(phone -> phone.setUser(userEntity));
        }
        return userMapper.toUser(jpaUserRepository.save(userEntity));
    }

    @Override
    public void deleteById(Long id) {
        jpaUserRepository.deleteById(id);
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpaUserRepository.existsByEmail(email);
    }
}
