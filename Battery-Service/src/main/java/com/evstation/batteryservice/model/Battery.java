package com.evstation.batteryservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Battery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;         // Mã pin
    private String type;         // Loại pin (ví dụ: LFP, NMC)
    private double capacity;     // Dung lượng (kWh)
    private String status;       // "AVAILABLE", "IN_USE", "CHARGING"
}
