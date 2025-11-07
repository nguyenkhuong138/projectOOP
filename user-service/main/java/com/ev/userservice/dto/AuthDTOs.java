package com.ev.userservice.dto;

import lombok.Data;

public class AuthDTOs {
    @Data
    public static class RegisterRequest {
        private String name;
        private String email;
        private String password;
        private String phone;
    }

    @Data
    public static class LoginRequest {
        private String email;
        private String password;
    }

    @Data
    public static class AuthResponse {
        private String token;
        private Long userId;
        private String email;
        private String name;
        private String role;
    }
}
