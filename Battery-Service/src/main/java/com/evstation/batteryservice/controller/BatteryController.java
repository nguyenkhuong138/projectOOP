package com.evstation.batteryservice.controller;


import com.evstation.batteryservice.model.Battery;
import com.evstation.batteryservice.repository.BatteryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/batteries")
public class BatteryController {
    private final BatteryRepository batteryRepository;
    public BatteryController(BatteryRepository batteryRepository) {
        this.batteryRepository = batteryRepository;
    }
    @GetMapping
    public List<Battery> findAll() {
        return batteryRepository.findAll();
    }
    @PostMapping
    public Battery save(@RequestBody Battery battery) {
        return batteryRepository.save(battery);
    }
}
