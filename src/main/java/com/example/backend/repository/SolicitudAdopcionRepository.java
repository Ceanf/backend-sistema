package com.example.backend.repository;

import com.example.backend.model.SolicitudAdopcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SolicitudAdopcionRepository extends JpaRepository<SolicitudAdopcion, Integer> {

    // Buscar solicitudes por usuario
    List<SolicitudAdopcion> findByUsuarioId(Integer usuarioId);

    // Buscar solicitudes por mascota
    List<SolicitudAdopcion> findByMascotaId(Integer mascotaId);

    // Buscar solicitudes por estado
    List<SolicitudAdopcion> findByEstadoSolicitud(
            SolicitudAdopcion.EstadoSolicitud estadoSolicitud);

    // Buscar solicitudes de un usuario por estado
    List<SolicitudAdopcion> findByUsuarioIdAndEstadoSolicitud(
            Integer usuarioId,
            SolicitudAdopcion.EstadoSolicitud estadoSolicitud);

    // 🛠️ CONSULTA EXPLÍCITA: Evita errores de "bad SQL grammar" asegurando los nombres de campos de tus entidades
    @Query("SELECT COUNT(s) > 0 FROM SolicitudAdopcion s WHERE s.usuario.id = :usuarioId AND s.mascota.id = :mascotaId AND s.estadoSolicitud = :estado")
    boolean existsByUsuarioIdAndMascotaIdAndEstadoSolicitud(
            @Param("usuarioId") Integer usuarioId, 
            @Param("mascotaId") Integer mascotaId, 
            @Param("estado") SolicitudAdopcion.EstadoSolicitud estado
    );
}