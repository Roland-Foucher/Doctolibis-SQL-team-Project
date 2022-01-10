package co.simplon.projetsql.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.simplon.projetsql.entity.Appointment;

public class AppointmentRepository implements IAppointmentRepository {

    private Connection connection;

    public AppointmentRepository() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://simplon:1234@localhost:3306/DOCTOLIBIS");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public boolean delApm(int id) {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("DELETE FROM appointment WHERE apm_id=?");
            stmt.setInt(1, id);
            return stmt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean editingApm(Appointment appointment) {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement(
                            "UPDATE appointment SET date=?, patient_id=?,medecin_id=? , apmType_id=? WHERE apm_id=?");
            stmt.setDate(1, Date.valueOf(appointment.getDate()));
            stmt.setInt(2, appointment.getPatient_id());
            stmt.setInt(3, appointment.getMedecin_id());
            stmt.setInt(4, appointment.getApmType_id());
            stmt.setInt(5, appointment.getApm_id());

            return stmt.executeUpdate() == 1;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Appointment showApm(int id) {
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM appointment WHERE  apm_id=?");
            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                return instanciateAppointment(result);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }


        return null;
    }

    @Override
    public List<Appointment> showListOfApm() {
        try {

            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM appointment");
            ResultSet result = stmt.executeQuery();
            List<Appointment> appointmentsList = new ArrayList<>();
            while (result.next()) {
                Appointment appointment = instanciateAppointment(result);
                appointmentsList.add(appointment);

            }
            return appointmentsList;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean takeApm(Appointment appointment) {
        try {

            if(appointment.getApm_id() != null) {
                return editingApm(appointment);
            }
            PreparedStatement stmt = connection
            .prepareStatement("INSERT INTO appointment (date,patient_id,medecin_id,apmType_id) VALUES (?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
           
            stmt.setDate(1, Date.valueOf(appointment.getDate()));
            stmt.setInt(2, appointment.getPatient_id());
            stmt.setInt(3, appointment.getMedecin_id());
            stmt.setInt(4, appointment.getApmType_id());

            if(stmt.executeUpdate() == 1) {
                ResultSet result = stmt.getGeneratedKeys();
                result.next();
                appointment.setApm_id(result.getInt(1));

                return true;
            }


        } catch (SQLException e) {
            
            e.printStackTrace();
        }


        return false;
    }

    private Appointment instanciateAppointment(ResultSet result) {
        try {
            return new Appointment(result.getInt("apm_id"),
                    result.getDate("date").toLocalDate(),
                    result.getInt("patient_id"),
                    result.getInt("medecin_id"),
                    result.getInt("apmType_id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
