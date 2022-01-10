package co.simplon.projetsql.repository;

import java.sql.Connection;
import java.util.List;

import co.simplon.projetsql.entity.Patient;

public interface IPatientReposotory {
    List<Patient> findAll();

    boolean addPatient(Patient patient);

    boolean modifyPatient(Patient patient);

    boolean deletePatient(Integer id);

    Patient displayPatient(Integer id);

    Connection getConnection();

}
