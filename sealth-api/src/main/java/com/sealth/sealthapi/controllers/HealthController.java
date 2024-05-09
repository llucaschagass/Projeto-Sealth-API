package com.sealth.sealthapi.controllers;

import com.sealth.sealthapi.dto.HealthDefaultsDTO;
import com.sealth.sealthapi.services.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {
    @Autowired
    private final HealthService healthService;

    public HealthController(HealthService healthService) {
        this.healthService = healthService;
    }

    @GetMapping("/defaults")
    public ResponseEntity<HealthDefaultsDTO> getDefaultValues() {
        HealthDefaultsDTO defaults = new HealthDefaultsDTO(
                healthService.getDefaultWeight(),
                healthService.getDefaultHeight(),
                healthService.getDefaultAge(),
                healthService.getDefaultSex()
        );
        return ResponseEntity.ok(defaults);
    }
}
