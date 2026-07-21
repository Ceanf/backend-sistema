package com.example.backend.service;

import com.example.backend.model.SolicitudVoluntario;
import com.example.backend.model.Voluntario;
import com.example.backend.repository.SolicitudVoluntarioRepository;
import com.example.backend.repository.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitudVoluntarioService {

    @Autowired
    private SolicitudVoluntarioRepository repository;

    @Autowired
    private VoluntarioRepository voluntarioRepository;

    // Registrar una nueva solicitud
    public SolicitudVoluntario guardarSolicitud(SolicitudVoluntario solicitud) {
        return repository.save(solicitud);
    }

    // Obtener todas las solicitudes
    public List<SolicitudVoluntario> obtenerTodas() {
        return repository.findAll();
    }

    // Aprobar una solicitud
    public SolicitudVoluntario aprobarSolicitud(Long id) {

        Optional<SolicitudVoluntario> optional = repository.findById(id);

        if (optional.isEmpty()) {
            throw new RuntimeException("Solicitud no encontrada.");
        }

        SolicitudVoluntario solicitud = optional.get();

        // Evitar aprobar una solicitud dos veces
        if ("APROBADA".equals(solicitud.getEstado())) {
            return solicitud;
        }

        // Cambiar estado de la solicitud
        solicitud.setEstado("APROBADA");

        // Crear el nuevo voluntario
        Voluntario voluntario = new Voluntario();
        voluntario.setNombre(solicitud.getNombreCompleto());
        voluntario.setTelefono(solicitud.getTelefono());
        voluntario.setExperiencia("Por definir");
        voluntario.setEstado("ACTIVO");

        voluntarioRepository.save(voluntario);

        // Guardar el nuevo estado de la solicitud
        return repository.save(solicitud);
    }

    // Rechazar una solicitud
    public SolicitudVoluntario rechazarSolicitud(Long id) {

        Optional<SolicitudVoluntario> optional = repository.findById(id);

        if (optional.isEmpty()) {
            throw new RuntimeException("Solicitud no encontrada.");
        }

        SolicitudVoluntario solicitud = optional.get();

        solicitud.setEstado("RECHAZADA");

        return repository.save(solicitud);
    }

    public void eliminarSolicitud(Long id) {

    if (!repository.existsById(id)) {
        throw new RuntimeException("Solicitud no encontrada.");
    }

    repository.deleteById(id);
}

}