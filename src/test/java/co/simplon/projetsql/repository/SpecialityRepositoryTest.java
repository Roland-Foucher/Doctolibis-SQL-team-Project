package co.simplon.projetsql.repository;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.simplon.projetsql.entity.Speciality;

public class SpecialityRepositoryTest {


    private ISpecialityRepository specialityRepository;

    @Before
    public void setUp() {
        specialityRepository = new SpecialityRepository();

        try {

            specialityRepository.getConnection().setAutoCommit(false);
           
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        try {
            //Après chaque test on "rollback" la base de données, c'est à dire qu'on
            //annule les modifications qu'on a possiblement faites dessus
            specialityRepository.getConnection().rollback();
            specialityRepository.getConnection().setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testAddRole() {
        Speciality toAdd = new Speciality("name");
        assertTrue(specialityRepository.addSpeciality(toAdd));

    }

    @Test
    public void testDeleteRole() {
        Speciality toAdd = new Speciality("name");
        specialityRepository.addSpeciality(toAdd);
        assertTrue(specialityRepository.deleteSpeciality(toAdd.getSpe_id()));

    }

    @Test
    public void testDisplayRole() {
        Speciality toAdd = new Speciality("name");
        specialityRepository.addSpeciality(toAdd);
        assertNotNull(specialityRepository.displaySpeciality(toAdd.getSpe_id()));
        

        
    }

    @Test
    public void testFindAll() {
        Speciality toAdd = new Speciality("name");
        specialityRepository.addSpeciality(toAdd);
        List<Speciality> result = specialityRepository.findAll();
        assertNotEquals(0, result.size());
    }

    @Test
    public void testModifyRole() {
        Speciality toAdd = new Speciality("name");
        specialityRepository.addSpeciality(toAdd);
        assertTrue(specialityRepository.modifySpeciality(toAdd)); 
        
    }
}


