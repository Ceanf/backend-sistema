package com.example.backend.service;

import com.example.backend.model.Mascota;
import com.example.backend.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays; // Importante para crear la lista de estados
import java.util.List;
import java.util.Optional;

@Service
public class MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    // ─── Listar para Catálogo (NUEVO MÉTODO) ───────────────
    // Muestra mascotas DISPONIBLES y EN_PROCESO
    public List<Mascota> listarParaCatalogo() {
        return mascotaRepository.findByEstadoIn(Arrays.asList(
                Mascota.EstadoMascota.DISPONIBLE, 
                Mascota.EstadoMascota.EN_PROCESO
        ));
    }

    public Mascota registrar(Mascota mascota) {
    // ESTA ES LA LÍNEA QUE TE FALTA:
    if (mascota.getFechaCreacion() == null) {
        mascota.setFechaCreacion(LocalDateTime.now());
    }
    
    return mascotaRepository.save(mascota);

}

    // ─── Listar todas las mascotas ─────────────────────────
    public List<Mascota> listarTodas() {
        return mascotaRepository.findAll();
    }

    // ─── Buscar mascota por ID ─────────────────────────────
    public Optional<Mascota> buscarPorId(Integer id) {
        return mascotaRepository.findById(id);
    }

    // ─── Buscar mascotas por especie ───────────────────────
    public List<Mascota> buscarPorEspecie(Mascota.Especie especie) {
        return mascotaRepository.findByEspecie(especie);
    }

   // ─── Actualizar mascota (Versión Profesional) ────────────────────────────────
public Mascota actualizar(Integer id, Mascota mascotaActualizada) {
    // 1. Buscamos la mascota existente
    Mascota mascotaExistente = mascotaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Mascota no encontrada con ID: " + id));

    // 2. Mapeo de datos (Validamos que no vengan nulos para mantener la integridad)
    if (mascotaActualizada.getNombre() != null) mascotaExistente.setNombre(mascotaActualizada.getNombre());
    if (mascotaActualizada.getEspecie() != null) mascotaExistente.setEspecie(mascotaActualizada.getEspecie());
    if (mascotaActualizada.getRaza() != null) mascotaExistente.setRaza(mascotaActualizada.getRaza());
    if (mascotaActualizada.getEdad() != null) mascotaExistente.setEdad(mascotaActualizada.getEdad());
    if (mascotaActualizada.getTamanio() != null) mascotaExistente.setTamanio(mascotaActualizada.getTamanio());
    if (mascotaActualizada.getSexo() != null) mascotaExistente.setSexo(mascotaActualizada.getSexo());
    
    // Aquí es donde manejamos tu lógica de los 4 estados: DISPONIBLE, ADOPTADO, EN_PROCESO, SUSPENDIDO
    if (mascotaActualizada.getEstado() != null) mascotaExistente.setEstado(mascotaActualizada.getEstado());
    
    if (mascotaActualizada.getDescripcion() != null) mascotaExistente.setDescripcion(mascotaActualizada.getDescripcion());
    if (mascotaActualizada.getFoto() != null) mascotaExistente.setFoto(mascotaActualizada.getFoto());

    // 3. Guardamos y retornamos
    return mascotaRepository.save(mascotaExistente);
}
    // ─── Cambiar estado de mascota ─────────────────────────
    public Mascota cambiarEstado(Integer id, Mascota.EstadoMascota nuevoEstado) {
        Mascota mascota = mascotaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada con ID: " + id));

        mascota.setEstado(nuevoEstado);
        return mascotaRepository.save(mascota);
    }

    // ─── Eliminar mascota ──────────────────────────────────
    public void eliminar(Integer id) {
        if (!mascotaRepository.existsById(id)) {
            throw new RuntimeException("Mascota no encontrada con ID: " + id);
        }
        mascotaRepository.deleteById(id);
    }
}