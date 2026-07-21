package com.example.backend.service;

import com.example.backend.model.SolicitudVoluntario;
import com.example.backend.repository.SolicitudVoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SolicitudVoluntarioService {

    @Autowired
    private SolicitudVoluntarioRepository repository;

    public SolicitudVoluntario guardarSolicitud(SolicitudVoluntario solicitud) {
        return repository.save(solicitud);
    }

    public List<SolicitudVoluntario> obtenerTodas() {
        return repository.findAll();
    }
}