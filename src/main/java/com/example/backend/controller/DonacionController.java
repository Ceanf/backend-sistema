package com.example.backend.controller;

import com.example.backend.model.Donacion;
import com.example.backend.repository.DonacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public ResponseEntity<Void> eliminar(@PathVariable Long id) {

    if (!repository.existsById(id)) {
        return ResponseEntity.notFound().build();
    }

    repository.deleteById(id);

    return ResponseEntity.noContent().build();
}

@GetMapping("/{id}")
public ResponseEntity<Donacion> obtenerPorId(@PathVariable Long id) {
    return repository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
}

@PutMapping("/{id}")
public ResponseEntity<Donacion> actualizar(
        @PathVariable Long id,
        @RequestBody Donacion nuevaDonacion) {

    return repository.findById(id)
            .map(donacion -> {

                donacion.setDonante(nuevaDonacion.getDonante());
                donacion.setMonto(nuevaDonacion.getMonto());
                donacion.setMetodoPago(nuevaDonacion.getMetodoPago());

                return ResponseEntity.ok(repository.save(donacion));

            }).orElse(ResponseEntity.notFound().build());
}
}   