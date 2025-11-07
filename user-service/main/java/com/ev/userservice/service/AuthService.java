package com.ev.userservice.service;

import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import lombok.RequiredArgsConstructor;
import com.ev.userservice.repository.UserRepository;
import com.ev.userservice.dto.AuthDTOs.*;
import com.ev.userservice.model.User;
import com.ev.userservice.model.Role;
import com.ev.userservice.security.JwtUtil;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthResponse register(RegisterRequest req) {
        if (userRepository.findByEmail(req.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }
        User u = User.builder()
            .name(req.getName())
            .email(req.getEmail())
            .password(passwordEncoder.encode(req.getPassword()))
            .phone(req.getPhone())
            .role(Role.DRIVER)
            .build();
        User saved = userRepository.save(u);
        String token = jwtUtil.generateToken(saved.getEmail());
        AuthResponse res = new AuthResponse();
        res.setToken(token); res.setUserId(saved.getId()); res.setEmail(saved.getEmail()); res.setName(saved.getName()); res.setRole(saved.getRole().name());
        return res;
    }

    public AuthResponse login(LoginRequest req) {
        Optional<User> ou = userRepository.findByEmail(req.getEmail());
        if (ou.isEmpty()) throw new RuntimeException("Invalid credentials");
        User u = ou.get();
        if (!passwordEncoder.matches(req.getPassword(), u.getPassword())) throw new RuntimeException("Invalid credentials");
        String token = jwtUtil.generateToken(u.getEmail());
        AuthResponse res = new AuthResponse();
        res.setToken(token); res.setUserId(u.getId()); res.setEmail(u.getEmail()); res.setName(u.getName()); res.setRole(u.getRole().name());
        return res;
    }
}
