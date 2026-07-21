package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "voluntarios")
@Data
public class Voluntario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String telefono;

    @Column(length = 1000)
    private String experiencia;

    private String estado = "PENDIENTE"; // Valor por defecto
}