package com.ev.userservice.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.ev.userservice.repository.UserRepository;
import com.ev.userservice.repository.VehicleRepository;
import com.ev.userservice.dto.UserDTOs.*;
import com.ev.userservice.model.User;
import com.ev.userservice.model.Vehicle;
import java.util.stream.Collectors;
import java.util.List;
import org.springframework.security.core.context.SecurityContextHolder;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final VehicleRepository vehicleRepository;

    public UserProfile getMyProfile() {
        User u = getAuthUser();
        return toProfile(u);
    }

    public UserProfile updateProfile(UserProfile dto) {
        User u = getAuthUser();
        u.setName(dto.getName());
        u.setPhone(dto.getPhone());
        u.setAvatar(dto.getAvatar());
        userRepository.save(u);
        return toProfile(u);
    }

    public VehicleDTO addVehicle(AddVehicleRequest req) {
        if (vehicleRepository.existsByVin(req.getVin())) throw new RuntimeException("VIN already linked");
        User u = getAuthUser();
        Vehicle v = Vehicle.builder().vin(req.getVin()).batteryType(req.getBatteryType()).status("ACTIVE").user(u).build();
        Vehicle saved = vehicleRepository.save(v);
        VehicleDTO dto = new VehicleDTO(); dto.setId(saved.getId()); dto.setVin(saved.getVin()); dto.setBatteryType(saved.getBatteryType()); dto.setStatus(saved.getStatus()); return dto;
    }

    public List<VehicleDTO> listMyVehicles() {
        User u = getAuthUser();
        return vehicleRepository.findByUserId(u.getId()).stream().map(v -> { VehicleDTO d = new VehicleDTO(); d.setId(v.getId()); d.setVin(v.getVin()); d.setBatteryType(v.getBatteryType()); d.setStatus(v.getStatus()); return d; }).collect(Collectors.toList());
    }

    private User getAuthUser() {
        Object p = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (p instanceof User) return (User) p;
        throw new RuntimeException("Not authenticated");
    }

    private UserProfile toProfile(User u) {
        UserProfile p = new UserProfile();
        p.setId(u.getId()); p.setName(u.getName()); p.setEmail(u.getEmail()); p.setPhone(u.getPhone()); p.setAvatar(u.getAvatar()); p.setRole(u.getRole().name());
        if (u.getVehicles() != null) p.setVehicles(u.getVehicles().stream().map(v -> { VehicleDTO d = new VehicleDTO(); d.setId(v.getId()); d.setVin(v.getVin()); d.setBatteryType(v.getBatteryType()); d.setStatus(v.getStatus()); return d; }).collect(Collectors.toList()));
        return p;
    }
}
