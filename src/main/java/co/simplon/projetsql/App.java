package co.simplon.projetsql;

import java.time.LocalDate;
import java.util.List;

import co.simplon.projetsql.entity.ApmType;
import co.simplon.projetsql.entity.Appointment;
import co.simplon.projetsql.entity.Patient;
import co.simplon.projetsql.entity.Role;
import co.simplon.projetsql.repository.ApmTypeRepository;
import co.simplon.projetsql.repository.AppointmentRepository;
import co.simplon.projetsql.repository.IAppointmentRepository;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Appointment appointment = new Appointment(LocalDate.of(2020, 10, 10), 1, 1, 1);
        AppointmentRepository appointmentRepository = new AppointmentRepository();
        appointmentRepository.takeApm(appointment);


    }
}
