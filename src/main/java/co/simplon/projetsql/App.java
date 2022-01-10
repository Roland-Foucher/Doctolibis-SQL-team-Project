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
        ApmTypeRepository apmTypeRepository = new ApmTypeRepository();
        
        apmTypeRepository.modifyApmType(apmTypeRepository.disPlayapmType(1));


    }
}
