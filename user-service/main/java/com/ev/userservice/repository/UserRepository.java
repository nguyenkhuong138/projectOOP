package com.ev.userservice.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ev.userservice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
