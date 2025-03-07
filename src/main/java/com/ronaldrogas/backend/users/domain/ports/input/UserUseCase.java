package com.ronaldrogas.backend.users.domain.ports.input;

import com.ronaldrogas.backend.users.domain.models.User;
import java.util.List;

public interface UserUseCase {
    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
}
