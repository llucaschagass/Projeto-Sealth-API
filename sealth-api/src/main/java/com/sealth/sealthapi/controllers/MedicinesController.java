package com.sealth.sealthapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class MedicinesController {

    private final List<String> pdfList = Arrays.asList("Paracetamol", "Omeprazol", "Amoxicilina", "Atorvastatina", "Metformina");

    @GetMapping("/medicines/pdf")
    public List<String> getRandomPDFs() {
        List<String> selectedPDFs = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            int index = random.nextInt(pdfList.size());
            String selectedPDF = pdfList.get(index);
            selectedPDFs.add(selectedPDF);
        }

        return selectedPDFs;
    }
}
