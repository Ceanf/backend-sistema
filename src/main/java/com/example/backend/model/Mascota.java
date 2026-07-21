package com.example.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mascotas")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(name = "especie", nullable = false)
    private Especie especie;

    @Column(name = "raza", length = 100)
    private String raza;

    @Column(name = "edad")
    private Integer edad;

    @Enumerated(EnumType.STRING)
    @Column(name = "tamanio", nullable = false)
    private Tamanio tamanio;

    @Enumerated(EnumType.STRING)
    @Column(name = "sexo", nullable = false)
    private Sexo sexo;

    // 🛠️ ADAPTACIÓN: Mapeo seguro para columna VARCHAR en base de datos manteniendo el Enum
    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, columnDefinition = "VARCHAR(50)")
    private EstadoMascota estado = EstadoMascota.DISPONIBLE;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "foto", length = 500)
    private String foto;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "fecha_ingreso", nullable = false, updatable = false)
    private LocalDate fechaIngreso = LocalDate.now();

    // ESTE ES EL ÚNICO CAMPO PARA LA FECHA DE CREACIÓN
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    // ─── Evento del Ciclo de Vida JPA ─────────────────
    @PrePersist
    public void prePersist() {
        if (this.fechaCreacion == null) {
            this.fechaCreacion = LocalDateTime.now();
            System.out.println("DEBUG: Asignando fecha de creación: " + this.fechaCreacion);
        }
    }

    // ─── Enums ─────────────────────────────────────────
    public enum Especie { PERRO, GATO, OTRO }
    public enum Tamanio { PEQUENIO, MEDIANO, GRANDE }
    public enum Sexo { MACHO, HEMBRA }
    public enum EstadoMascota { DISPONIBLE, EN_PROCESO, ADOPTADO, SUSPENDIDO }
}