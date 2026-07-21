package com.example.backend.service;

import com.example.backend.dto.DashboardDTO;
import com.example.backend.model.Mascota;
import com.example.backend.model.SolicitudAdopcion;
import com.example.backend.repository.DonacionRepository;
import com.example.backend.repository.MascotaRepository;
import com.example.backend.repository.SolicitudAdopcionRepository;
import com.example.backend.repository.UsuarioRepository;
import com.example.backend.repository.VoluntarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final MascotaRepository mascotaRepository;
    private final SolicitudAdopcionRepository solicitudRepository;
    private final UsuarioRepository usuarioRepository;
    private final DonacionRepository donacionRepository;
    private final VoluntarioRepository voluntarioRepository;

    public DashboardDTO obtenerEstadisticas() {

        DashboardDTO dto = new DashboardDTO();

        // ===========================
        // MASCOTAS
        // ===========================

        dto.setTotalMascotas(mascotaRepository.count());

        dto.setMascotasDisponibles(
                mascotaRepository.countByEstado(Mascota.EstadoMascota.DISPONIBLE));

        dto.setMascotasEnProceso(
                mascotaRepository.countByEstado(Mascota.EstadoMascota.EN_PROCESO));

        dto.setMascotasAdoptadas(
                mascotaRepository.countByEstado(Mascota.EstadoMascota.ADOPTADO));

        dto.setMascotasSuspendidas(
                mascotaRepository.countByEstado(Mascota.EstadoMascota.SUSPENDIDO));

        // ===========================
        // SOLICITUDES
        // ===========================

        dto.setTotalSolicitudes(solicitudRepository.count());

        dto.setSolicitudesEnviadas(
                solicitudRepository.countByEstadoSolicitud(
                        SolicitudAdopcion.EstadoSolicitud.ENVIADA));

        dto.setSolicitudesRevision(
                solicitudRepository.countByEstadoSolicitud(
                        SolicitudAdopcion.EstadoSolicitud.EN_REVISION));

        dto.setSolicitudesAprobadas(
                solicitudRepository.countByEstadoSolicitud(
                        SolicitudAdopcion.EstadoSolicitud.APROBADA));

        dto.setSolicitudesDenegadas(
                solicitudRepository.countByEstadoSolicitud(
                        SolicitudAdopcion.EstadoSolicitud.DENEGADA));

        // ===========================
        // USUARIOS
        // ===========================

        dto.setTotalUsuarios(usuarioRepository.count());

        // ===========================
        // VOLUNTARIOS
        // ===========================

        dto.setTotalVoluntarios(voluntarioRepository.count());

        // ===========================
        // DONACIONES
        // ===========================

        dto.setTotalDonaciones(donacionRepository.count());

        Double monto = donacionRepository.obtenerMontoTotalDonado();

        dto.setMontoTotalDonaciones(
                monto != null ? monto : 0.0);

        return dto;
    }

}