package com.example.backend.controller;

import com.example.backend.model.Voluntario;
import com.example.backend.model.SolicitudVoluntario;
import com.example.backend.repository.VoluntarioRepository;
import com.example.backend.service.SolicitudVoluntarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/voluntarios")
@CrossOrigin(origins = "*") 
public class VoluntarioController {

    @Autowired
    private VoluntarioRepository repository;

    @Autowired
    private SolicitudVoluntarioService solicitudService;

    // --- MÉTODOS EXISTENTES ---
    @PostMapping
    public Voluntario registrar(@RequestBody Voluntario nuevoVoluntario) {
        return repository.save(nuevoVoluntario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repository.deleteById(id);
    }

    // --- MÉTODOS NUEVOS PARA SOLICITUDES DEL FORMULARIO ---
    
    // Ruta para recibir el formulario: POST /api/voluntarios/solicitud
    @PostMapping("/solicitud")
    public SolicitudVoluntario registrarSolicitud(@RequestBody SolicitudVoluntario solicitud) {
        return solicitudService.guardarSolicitud(solicitud);
    }

    // Ruta para que el admin vea todas las solicitudes: GET /api/voluntarios/solicitudes
    @GetMapping("/solicitudes")
    public List<SolicitudVoluntario> listarSolicitudes() {
        return solicitudService.obtenerTodas();
    }
}