package com.plantes.backend.repositories;

import com.plantes.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByIdGreaterThan(Long id);
}
