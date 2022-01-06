package co.simplon.projetsql.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.simplon.projetsql.entity.Appointment;

public class AppointmentRepository implements IAppointmentRepository {

    @Override
    public void delApm(int id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void editingApm(Appointment appointment) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Appointment showApm(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Appointment> showListOfApm() {
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://simplon:1234@localhost:3306/DOCTOLIBIS");   
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM appointment");
            ResultSet result = stmt.executeQuery();
            List<Appointment> appointmentsList = new ArrayList<>();
            while(result.next()) {
                Appointment appointment = new Appointment(result.getInt("apm_id"), 
                                                        result.getDate("date").toLocalDate(),
                                                        result.getInt("patient_id"), 
                                                        result.getInt("medecin_id"),
                                                        result.getInt("apmType_id"));
                appointmentsList.add(appointment);
                
            }
            return appointmentsList;
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void takeApm(Appointment appointment) {
        // TODO Auto-generated method stub
        
    }

    
}
