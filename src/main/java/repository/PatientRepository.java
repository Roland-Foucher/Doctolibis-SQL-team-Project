package repository;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.simplon.projetsql.entity.Patient;

public class PatientRepository implements IPatientReposotory {

    @Override
    public List<Patient> findAll() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://simplon:1234@localhost:3306/DOCTOLIBIS");
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM patient");
            ResultSet result = stmt.executeQuery();
            List<Patient> patientList = new ArrayList<>();
            while (result.next()) {
                Patient patient = new Patient(
                        result.getInt("patient_id"),
                        result.getInt("user_id"),
                        result.getInt("phoneNumber"),
                        result.getInt("secuNumber"));
                patientList.add(patient);
            }
            return patientList;
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addPatient() {
        // TODO Auto-generated method stub

    }

    @Override
    public void modifyPatient() {
        // TODO Auto-generated method stub

    }

    @Override
    public void deletePatient() {
        // TODO Auto-generated method stub

    }

    @Override
    public Patient displayPatient() {
        // TODO Auto-generated method stub
        return null;
    }

}
