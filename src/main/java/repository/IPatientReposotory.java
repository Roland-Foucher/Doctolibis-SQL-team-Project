package repository;

import java.util.List;

import co.simplon.projetsql.entity.Patient;

public interface IPatientReposotory {
    List<Patient> findAll();

    void addPatient();

    void modifyPatient();

    void deletePatient();

    Patient displayPatient();

}
