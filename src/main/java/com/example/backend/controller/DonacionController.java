package com.example.backend.controller;

import com.example.backend.model.Donacion;
import com.example.backend.repository.DonacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/donaciones")
@CrossOrigin(origins = "*")
public class DonacionController {

    @Autowired
    private DonacionRepository repository;

    @PostMapping
    public Donacion registrar(@RequestBody Donacion donacion) {
        return repository.save(donacion);
    }

    @GetMapping
    public List<Donacion> listarTodas() {
        return repository.findAll();
    }
    // Agrega este método dentro de tu clase DonacionController
@DeleteMapping("/{id}")
public void eliminar(@PathVariable Long id) {
    repository.deleteById(id);
}
}   