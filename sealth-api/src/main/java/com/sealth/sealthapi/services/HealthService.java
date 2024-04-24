package com.sealth.sealthapi.services;

import org.springframework.stereotype.Service;

@Service
public class HealthService {

    public double getDefaultWeight() {
        return 70.0;
    }

    public double getDefaultHeight() {
        return 1.75;
    }

    public int getDefaultAge() {
        return 30;
    }

    public String getDefaultSex() {
        return "masculino";
    }
}
