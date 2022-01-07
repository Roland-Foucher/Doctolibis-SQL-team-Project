package co.simplon.projetsql.repository;

import java.util.List;

import co.simplon.projetsql.entity.Patient;

public interface IPatientReposotory {
    List<Patient> findAll(Integer id);

    boolean addPatient(Patient patient);

    boolean modifyPatient(Patient patient);

    boolean deletePatient(Integer id);

    Patient displayPatient(Integer id);

}
