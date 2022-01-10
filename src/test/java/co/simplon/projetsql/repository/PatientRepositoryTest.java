package co.simplon.projetsql.repository;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.simplon.projetsql.entity.Patient;

public class PatientRepositoryTest {

    private IPatientReposotory patientRepository;

    @Before
    public void setUp() {
        patientRepository = new PatientRepository();

        try {

            patientRepository.getConnection().setAutoCommit(false);
           
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        try {
            //Après chaque test on "rollback" la base de données, c'est à dire qu'on
            //annule les modifications qu'on a possiblement faites dessus
            patientRepository.getConnection().rollback();
            patientRepository.getConnection().setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testAddPatient() {
        Patient toAdd = new Patient(1, "19208908");
        assertTrue(patientRepository.addPatient(toAdd));

    }

    @Test
    public void testDeletePatient() {
        Patient toAdd = new Patient(1, "19208908");
        patientRepository.addPatient(toAdd);
        assertTrue(patientRepository.deletePatient(toAdd.getPatient_id()));

    }

    @Test
    public void testDisplayPatient() {
        Patient toAdd = new Patient(1, "19208908");
        patientRepository.addPatient(toAdd);
        assertNotNull(patientRepository.displayPatient(toAdd.getPatient_id()));
        

        
    }

    @Test
    public void testFindAll() {
        Patient toAdd = new Patient(1, "19208908");
        patientRepository.addPatient(toAdd);
        List<Patient> result = patientRepository.findAll();
        assertNotEquals(0, result.size());
    }

    @Test
    public void testModifyPatient() {
        Patient toAdd = new Patient(1, "19208908");
        patientRepository.addPatient(toAdd);
        assertTrue(patientRepository.modifyPatient(toAdd)); 
        
    }
}
