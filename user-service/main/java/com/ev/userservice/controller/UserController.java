package com.ev.userservice.controller;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import com.ev.userservice.service.UserService;
import com.ev.userservice.dto.UserDTOs.*;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/profile")
    public UserProfile profile() { return userService.getMyProfile(); }

    @PutMapping("/profile")
    public UserProfile updateProfile(@RequestBody UserProfile dto) { return userService.updateProfile(dto); }

    @PostMapping("/vehicle")
    public VehicleDTO addVehicle(@RequestBody AddVehicleRequest req) { return userService.addVehicle(req); }

    @GetMapping("/vehicle")
    public List<VehicleDTO> listVehicles() { return userService.listMyVehicles(); }
}
