package com.example.backend.repository;

import com.example.backend.model.Voluntario; // IMPORTANTE: Ajustado a tu estructura
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface VoluntarioRepository extends JpaRepository<Voluntario, Long> {
}