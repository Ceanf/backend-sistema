package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "donaciones")
@Data
public class Donacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String donante;

    @Column(nullable = false)
    private Double monto;

    @Column(nullable = false)
    private String metodoPago;

    private LocalDateTime fechaDonacion = LocalDateTime.now();
}