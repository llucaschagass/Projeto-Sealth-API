package com.sealth.sealthapi.dto;

import java.time.LocalDate;

public record AppointmentDTO(LocalDate date, String doctor, String specialty, String location, String extraInfo) {
}
