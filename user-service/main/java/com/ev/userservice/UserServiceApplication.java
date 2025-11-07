package com.ev.userservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ev.userservice.model.User;
import com.ev.userservice.model.Role;
import com.ev.userservice.repository.UserRepository;

@SpringBootApplication
public class UserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            if (userRepository.findByEmail("admin@example.com").isEmpty()) {
                BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
                User admin = new User();
                admin.setName("Admin");
                admin.setEmail("admin@example.com");
                admin.setPassword(enc.encode("admin123"));
                admin.setRole(Role.DRIVER);
                userRepository.save(admin);
                System.out.println("Default driver created: admin@example.com / admin123 (role DRIVER)"); 
            }
        };
    }
}
