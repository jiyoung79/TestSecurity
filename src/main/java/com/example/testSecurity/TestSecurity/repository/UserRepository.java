package com.example.testSecurity.TestSecurity.repository;

import com.example.testSecurity.TestSecurity.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    boolean existsByUsername(String username);
    UserEntity findByUsername(String username);
}
