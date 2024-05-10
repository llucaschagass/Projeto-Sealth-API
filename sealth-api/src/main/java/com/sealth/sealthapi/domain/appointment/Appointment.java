package com.sealth.sealthapi.domain.appointment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "appointments")
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "appointment_date")
    private LocalDate date;

    @Column(name = "doctor")
    private String doctor;

    @Column(name = "specialty")
    private String specialty;

    @Column(name = "location")
    private String location;

    @Column(name = "extra_info")
    private String extraInfo;

    public Appointment(String date, String doctor, String specialty, String location, String extraInfo) {
        this.date = LocalDate.parse(date);
        this.doctor = doctor;
        this.specialty = specialty;
        this.location = location;
        this.extraInfo = extraInfo;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDoctor() {
        return doctor;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getLocation() {
        return location;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }
}
