package com.sealth.sealthapi.dto;

public record UpdateAppointmentRequestDTO(String date, String doctor, String specialty, String location, String extraInformation) {}