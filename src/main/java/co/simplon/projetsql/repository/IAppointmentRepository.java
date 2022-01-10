package co.simplon.projetsql.repository;

import java.sql.Connection;
import java.util.List;

import co.simplon.projetsql.entity.Appointment;

public interface IAppointmentRepository {
    boolean takeApm(Appointment appointment);

    Appointment showApm(int id);

    boolean delApm(int id);

    boolean editingApm(Appointment appointment);

    List<Appointment> showListOfApm();

    Connection getConnection();
}
