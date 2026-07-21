package com.example.backend.controller;

import com.example.backend.model.SolicitudVoluntario;
import com.example.backend.model.Voluntario;
import com.example.backend.repository.VoluntarioRepository;
import com.example.backend.service.SolicitudVoluntarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.ResponseEntity;
@RestController
@RequestMapping("/api/voluntarios")
@CrossOrigin(origins = "*")
public class VoluntarioController {

    @Autowired
    private VoluntarioRepository repository;

    @Autowired
    private SolicitudVoluntarioService solicitudService;

    // ==========================================
    // CRUD DE VOLUNTARIOS
    // ==========================================

    // Registrar voluntario
    @PostMapping
    public Voluntario registrar(@RequestBody Voluntario nuevoVoluntario) {
        return repository.save(nuevoVoluntario);
    }

    // Listar todos los voluntarios
    @GetMapping
    public List<Voluntario> listarTodos() {
        return repository.findAll();
    }

    // Buscar voluntario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Voluntario> obtenerPorId(@PathVariable Long id) {

        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    // Actualizar voluntario
    @PutMapping("/{id}")
    public ResponseEntity<Voluntario> actualizar(
            @PathVariable Long id,
            @RequestBody Voluntario nuevoVoluntario) {

        return repository.findById(id)
                .map(voluntario -> {

                    voluntario.setNombre(nuevoVoluntario.getNombre());
                    voluntario.setTelefono(nuevoVoluntario.getTelefono());
                    voluntario.setExperiencia(nuevoVoluntario.getExperiencia());
                    voluntario.setEstado(nuevoVoluntario.getEstado());

                    return ResponseEntity.ok(repository.save(voluntario));

                }).orElse(ResponseEntity.notFound().build());

    }

    // Eliminar voluntario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);

        return ResponseEntity.noContent().build();

    }

    // ==========================================
    // SOLICITUDES DE VOLUNTARIADO
    // ==========================================

    // Registrar solicitud desde el formulario público
    @PostMapping("/solicitud")
    public SolicitudVoluntario registrarSolicitud(
            @RequestBody SolicitudVoluntario solicitud) {

        return solicitudService.guardarSolicitud(solicitud);

    }

    // Listar todas las solicitudes
    @GetMapping("/solicitudes")
    public List<SolicitudVoluntario> listarSolicitudes() {

        return solicitudService.obtenerTodas();

    }


    @PutMapping("/solicitudes/{id}/aprobar")
public SolicitudVoluntario aprobarSolicitud(@PathVariable Long id) {
    return solicitudService.aprobarSolicitud(id);
}

@PutMapping("/solicitudes/{id}/rechazar")
public SolicitudVoluntario rechazarSolicitud(@PathVariable Long id) {
    return solicitudService.rechazarSolicitud(id);
}

@DeleteMapping("/solicitudes/{id}")
public ResponseEntity<Void> eliminarSolicitud(@PathVariable Long id) {

    solicitudService.eliminarSolicitud(id);

    return ResponseEntity.noContent().build();
}
}