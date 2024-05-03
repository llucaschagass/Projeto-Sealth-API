package com.sealth.sealthapi.dto;

public record CreateAppointmentRequestDTO(String date, String doctor, String specialty, String location, String extraInfo) {}