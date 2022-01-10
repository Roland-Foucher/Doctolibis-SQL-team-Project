package co.simplon.projetsql.repository;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.simplon.projetsql.entity.ApmType;
import co.simplon.projetsql.entity.Appointment;

public class AppointmentRepositoryTest {
    private IAppointmentRepository appointmentRepository;
    @Before
    public void setUp(){
        appointmentRepository = new AppointmentRepository();

         try {
            appointmentRepository.getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @After
    public void tearDown(){
        try {
            appointmentRepository.getConnection().rollback();
            appointmentRepository.getConnection().setAutoCommit(true);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
    }

    @Test
    public void testTakeApm() {
       Appointment appointment = new Appointment(LocalDate.of(2021, 02, 12), 1, 1, 1);
       assertTrue(appointmentRepository.takeApm(appointment));

    }

    @Test
    public void testDeleteApm() {
        Appointment appointment = new Appointment(LocalDate.of(2021, 02, 12), 1, 1, 1);
        appointmentRepository.takeApm(appointment);
        assertTrue(appointmentRepository.delApm(appointment.getApm_id()));
        
    }

    @Test
    public void testDisPlayApm() {
        Appointment appointment = new Appointment(LocalDate.of(2021, 02, 12), 1, 1, 1);
        appointmentRepository.takeApm(appointment);
        assertNotNull(appointmentRepository.showApm(appointment.getApm_id())); 
        
    }

    @Test
    public void testModifyApm() {
        Appointment appointment = new Appointment(LocalDate.of(2021, 02, 12), 1, 1, 1);
        appointmentRepository.takeApm(appointment);
        assertTrue(appointmentRepository.editingApm(appointment));

    }

    @Test
    public void testShowListOfApm() {
        Appointment appointment = new Appointment(LocalDate.of(2021, 02, 12), 1, 1, 1);
        appointmentRepository.takeApm(appointment);
        List <Appointment> list = appointmentRepository.showListOfApm();
        assertNotEquals(0, list.size());
    }
}
