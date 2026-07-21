package com.example.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DashboardDTO {

    // ==========================
    // MASCOTAS
    // ==========================
    private Long totalMascotas;
    private Long mascotasDisponibles;
    private Long mascotasEnProceso;
    private Long mascotasAdoptadas;
    private Long mascotasSuspendidas;

    // ==========================
    // SOLICITUDES
    // ==========================
    private Long totalSolicitudes;
    private Long solicitudesEnviadas;
    private Long solicitudesRevision;
    private Long solicitudesAprobadas;
    private Long solicitudesDenegadas;

    // ==========================
    // USUARIOS
    // ==========================
    private Long totalUsuarios;

    // ==========================
    // VOLUNTARIOS
    // ==========================
    private Long totalVoluntarios;

    // ==========================
    // DONACIONES
    // ==========================
    private Long totalDonaciones;
    private Double montoTotalDonaciones;

}