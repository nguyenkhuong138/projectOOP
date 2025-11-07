package com.ev.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ev.userservice.model.Vehicle;
import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByUserId(Long userId);
    boolean existsByVin(String vin);
}
