package com.healthclinic.dao;

import com.healthclinic.dto.Appointment;

import java.util.List;

public interface AppointmentDAO {

    boolean addAppointment(Appointment appointment);

    boolean updateAppointment(Appointment appointment);

    boolean deleteAppointment(int appointmentId);

    Appointment getAppointmentById(int appointmentId);

    List<Appointment> getAllAppointments();
}