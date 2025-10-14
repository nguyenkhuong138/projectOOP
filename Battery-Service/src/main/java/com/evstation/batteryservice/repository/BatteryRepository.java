package com.evstation.batteryservice.repository;

import com.evstation.batteryservice.model.Battery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BatteryRepository extends JpaRepository<Battery,Long> {
    List<Battery> findByStatus(String status);
}
