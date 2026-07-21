package com.example.backend.repository;

import com.example.backend.model.SolicitudVoluntario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitudVoluntarioRepository extends JpaRepository<SolicitudVoluntario, Long> {
    // Ya incluye métodos como save(), findAll(), deleteById(), etc.
}