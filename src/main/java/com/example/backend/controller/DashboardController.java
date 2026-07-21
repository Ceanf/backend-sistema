package com.example.backend.controller;

import com.example.backend.dto.DashboardDTO;
import com.example.backend.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping
    public ResponseEntity<DashboardDTO> obtenerEstadisticas() {

        DashboardDTO dashboard = dashboardService.obtenerEstadisticas();

        return ResponseEntity.ok(dashboard);
    }

}