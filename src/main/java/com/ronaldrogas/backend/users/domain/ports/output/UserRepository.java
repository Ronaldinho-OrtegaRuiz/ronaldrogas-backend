package com.ronaldrogas.backend.users.domain.ports.output;

import com.ronaldrogas.backend.users.domain.models.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> findAll();
    Optional<User> findById(Long id);
    Optional<User> getUserByEmail(String email);
    User save(User user);
    void deleteById(Long id);
    boolean existsByEmail(String email);
}
