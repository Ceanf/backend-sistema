package com.example.backend.dto;

public class DashboardDTO {

    private long totalMascotas;
    private long mascotasDisponibles;
    private long mascotasAdoptadas;

    private long totalSolicitudes;
    private long solicitudesPendientes;
    private long solicitudesAprobadas;
    private long solicitudesDenegadas;

    private long totalUsuarios;
    private long totalVoluntarios;

    private long totalDonaciones;
    private double montoDonaciones;

    public DashboardDTO() {
    }

    public long getTotalMascotas() {
        return totalMascotas;
    }

    public void setTotalMascotas(long totalMascotas) {
        this.totalMascotas = totalMascotas;
    }

    public long getMascotasDisponibles() {
        return mascotasDisponibles;
    }

    public void setMascotasDisponibles(long mascotasDisponibles) {
        this.mascotasDisponibles = mascotasDisponibles;
    }

    public long getMascotasAdoptadas() {
        return mascotasAdoptadas;
    }

    public void setMascotasAdoptadas(long mascotasAdoptadas) {
        this.mascotasAdoptadas = mascotasAdoptadas;
    }

    public long getTotalSolicitudes() {
        return totalSolicitudes;
    }

    public void setTotalSolicitudes(long totalSolicitudes) {
        this.totalSolicitudes = totalSolicitudes;
    }

    public long getSolicitudesPendientes() {
        return solicitudesPendientes;
    }

    public void setSolicitudesPendientes(long solicitudesPendientes) {
        this.solicitudesPendientes = solicitudesPendientes;
    }

    public long getSolicitudesAprobadas() {
        return solicitudesAprobadas;
    }

    public void setSolicitudesAprobadas(long solicitudesAprobadas) {
        this.solicitudesAprobadas = solicitudesAprobadas;
    }

    public long getSolicitudesDenegadas() {
        return solicitudesDenegadas;
    }

    public void setSolicitudesDenegadas(long solicitudesDenegadas) {
        this.solicitudesDenegadas = solicitudesDenegadas;
    }

    public long getTotalUsuarios() {
        return totalUsuarios;
    }

    public void setTotalUsuarios(long totalUsuarios) {
        this.totalUsuarios = totalUsuarios;
    }

    public long getTotalVoluntarios() {
        return totalVoluntarios;
    }

    public void setTotalVoluntarios(long totalVoluntarios) {
        this.totalVoluntarios = totalVoluntarios;
    }

    public long getTotalDonaciones() {
        return totalDonaciones;
    }

    public void setTotalDonaciones(long totalDonaciones) {
        this.totalDonaciones = totalDonaciones;
    }

    public double getMontoDonaciones() {
        return montoDonaciones;
    }

    public void setMontoDonaciones(double montoDonaciones) {
        this.montoDonaciones = montoDonaciones;
    }
}