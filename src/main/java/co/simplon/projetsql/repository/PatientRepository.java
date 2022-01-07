package co.simplon.projetsql.repository;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.simplon.projetsql.entity.Patient;

public class PatientRepository implements IPatientReposotory {
    Connection connection;

    public PatientRepository() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://simplon:1234@localhost:3306/DOCTOLIBIS");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Patient> findAll(Integer id) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://simplon:1234@localhost:3306/DOCTOLIBIS");
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM patient");
            ResultSet result = stmt.executeQuery();
            List<Patient> patientList = new ArrayList<>();
            while (result.next()) {
                Patient patient = instanciatePatient(result);
                patientList.add(patient);
            }
            return patientList;
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addPatient(Patient patient) {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement(
                            "INSERT INTO patient (patient_id, user_id, phoneNumber, secuNumber) VALUES (?,?,?,?)",
                            PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, patient.getPatient_id());
            stmt.setInt(2, patient.getUser_id());
            stmt.setInt(3, patient.getPhoneNumber());
            stmt.setInt(3, patient.getSecuNumber());

            if (stmt.executeUpdate() == 1) {
                ResultSet result = stmt.getGeneratedKeys();
                result.next();
                patient.setPatient_id(result.getInt(1));

                return true;
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;

    }

    @Override
    public boolean modifyPatient(Patient patient) {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement(
                            "UPDATE patient SET patient_id=?, user_id=?, phoneNumber=?, secuNumber=? WHERE patient_id=?");
            stmt.setInt(1, patient.getPatient_id());
            stmt.setInt(2, patient.getUser_id());
            stmt.setInt(3, patient.getPhoneNumber());
            stmt.setInt(3, patient.getSecuNumber());

            return stmt.executeUpdate() == 1;

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deletePatient(Integer id) {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("DELETE FROM patient WHERE patient_id=?");
            stmt.setInt(1, id);
            return stmt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Patient displayPatient(Integer id) {
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM patient WHERE patient_id=?");
            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                return instanciatePatient(result);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }

    private Patient instanciatePatient(ResultSet result) {
        try {
            return new Patient(
                    result.getInt("patient_id"),
                    result.getInt("user_id"),
                    result.getInt("phoneNumber"),
                    result.getInt("secuNumber"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

}
