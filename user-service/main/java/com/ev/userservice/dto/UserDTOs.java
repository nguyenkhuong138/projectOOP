package com.ev.userservice.dto;

import lombok.Data;
import java.util.List;

public class UserDTOs {
    @Data
    public static class UserProfile {
        private Long id;
        private String name;
        private String email;
        private String phone;
        private String avatar;
        private String role;
        private List<VehicleDTO> vehicles;
    }

    @Data
    public static class VehicleDTO {
        private Long id;
        private String vin;
        private String batteryType;
        private String status;
    }

    @Data
    public static class AddVehicleRequest {
        private String vin;
        private String batteryType;
    }
}
