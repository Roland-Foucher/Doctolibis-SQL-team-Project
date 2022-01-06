package co.simplon.projetsql.repository;

import java.util.List;

import co.simplon.projetsql.entity.Appointment;

public interface IAppointmentRepository {
void takeApm(Appointment appointment);   
Appointment showApm(int id);
void delApm(int id);
void editingApm( Appointment appointment);
List<Appointment> showListOfApm();
}
