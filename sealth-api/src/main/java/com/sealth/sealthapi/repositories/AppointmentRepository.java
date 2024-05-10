package com.sealth.sealthapi.repositories;

import com.sealth.sealthapi.domain.appointment.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    Optional<Appointment> findByDate(LocalDate date);
    List<Appointment> findByDoctor(String doctor);
}
