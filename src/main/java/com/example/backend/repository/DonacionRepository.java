package com.example.backend.repository;

import com.example.backend.model.Donacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DonacionRepository extends JpaRepository<Donacion, Long> {

    @Query("SELECT COALESCE(SUM(d.monto),0) FROM Donacion d")
Double obtenerMontoTotalDonado();
}