package com.healthclinic.service;

import com.healthclinic.dao.AppointmentDAO;
import com.healthclinic.dao.AppointmentDAOImpl;
import com.healthclinic.dto.Appointment;
import com.healthclinic.exception.ValidationException;

import java.util.List;

public class AppointmentService {

    private final AppointmentDAO appointmentDAO =
            new AppointmentDAOImpl();

    public boolean addAppointment(Appointment appointment) {

        if (appointment.getPatientId() <= 0)
            throw new ValidationException("Invalid Patient ID.");

        if (appointment.getDoctorId() <= 0)
            throw new ValidationException("Invalid Doctor ID.");

        if (appointment.getAppointmentDate() == null)
            throw new ValidationException("Appointment Date is required.");

        if (appointment.getAppointmentTime() == null)
            throw new ValidationException("Appointment Time is required.");

        if (appointment.getReason() == null ||
                appointment.getReason().isBlank())
            throw new ValidationException("Reason cannot be empty.");

        if (appointment.getStatus() == null ||
                appointment.getStatus().isBlank())
            appointment.setStatus("Scheduled");

        return appointmentDAO.addAppointment(appointment);
    }

    public boolean updateAppointment(Appointment appointment) {
        return appointmentDAO.updateAppointment(appointment);
    }

    public boolean deleteAppointment(int appointmentId) {
        return appointmentDAO.deleteAppointment(appointmentId);
    }

    public Appointment getAppointmentById(int appointmentId) {
        return appointmentDAO.getAppointmentById(appointmentId);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentDAO.getAllAppointments();
    }
}