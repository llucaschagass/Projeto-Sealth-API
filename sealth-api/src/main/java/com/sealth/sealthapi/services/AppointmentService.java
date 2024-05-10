package com.sealth.sealthapi.services;

import com.sealth.sealthapi.domain.appointment.Appointment;
import com.sealth.sealthapi.dto.CreateAppointmentRequestDTO;
import com.sealth.sealthapi.dto.UpdateAppointmentRequestDTO;
import com.sealth.sealthapi.repositories.AppointmentRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @PostConstruct
    public void initializeAppointments() {
        CreateAppointmentRequestDTO appointment1Request = new CreateAppointmentRequestDTO(
                "2024-05-25",
                "Dr. Silva",
                "Cardiologia",
                "Hospital ABC - Contagem",
                "Extra info 1"
        );
        createAppointment(appointment1Request);

        CreateAppointmentRequestDTO appointment2Request = new CreateAppointmentRequestDTO(
                "2024-05-26",
                "Dra. Souza",
                "Ortopedia",
                "Hospital XYZ - Betim",
                "Dores nas costas"
        );
        createAppointment(appointment2Request);
    }

    public Appointment createAppointment(CreateAppointmentRequestDTO request) {
        LocalDate appointmentDate = LocalDate.parse(request.date());
        Appointment appointment = new Appointment(
                request.date(),
                request.doctor(),
                request.specialty(),
                request.location(),
                request.extraInfo()
        );
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment updateAppointment(Long appointmentId, UpdateAppointmentRequestDTO request) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
        appointment.setDate(LocalDate.parse(request.date()));
        appointment.setDoctor(request.doctor());
        appointment.setSpecialty(request.specialty());
        appointment.setLocation(request.location());
        appointment.setExtraInfo(request.extraInformation());
        return appointmentRepository.save(appointment);
    }

    public void cancelAppointment(Long appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }
}
