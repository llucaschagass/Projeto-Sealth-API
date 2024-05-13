package com.sealth.sealthapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class MedicinesController {

    // Lista de todos os medicamentos disponíveis
    private final List<String> allMedicines = Arrays.asList("Paracetamol", "Omeprazol", "Amoxicilina", "Atorvastatina", "Metformina");

    @GetMapping("/medicines/pdf")
    public List<String> getAllPDFs() {
        // Retorna a lista completa de medicamentos
        return allMedicines;
    }
}