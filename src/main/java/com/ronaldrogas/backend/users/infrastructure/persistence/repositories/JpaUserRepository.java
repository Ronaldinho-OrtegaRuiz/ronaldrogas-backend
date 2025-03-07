package com.ronaldrogas.backend.users.infrastructure.persistence.repositories;

import com.ronaldrogas.backend.users.infrastructure.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByEmail(String email);
} 