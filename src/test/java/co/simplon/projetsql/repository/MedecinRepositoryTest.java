package co.simplon.projetsql.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.simplon.projetsql.entity.Medecin;

public class MedecinRepositoryTest {

    private IMedecinRepository medecinRepository;

    @Before
    public void setUp() {
        medecinRepository = new MedecinRepository();

        try {

            medecinRepository.getConnection().setAutoCommit(false);
           
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        try {
            //Après chaque test on "rollback" la base de données, c'est à dire qu'on
            //annule les modifications qu'on a possiblement faites dessus
            medecinRepository.getConnection().rollback();
            medecinRepository.getConnection().setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Test
    public void testAddMedecin() {
        Medecin toAdd = new Medecin(1, "adresse", "legalMention", "presentation", 10);
        assertTrue(medecinRepository.addMedecin(toAdd));

    }

    @Test
    public void testDeleteMedecin() {
        Medecin toAdd = new Medecin(1, "adresse", "legalMention", "presentation", 10);
        medecinRepository.addMedecin(toAdd);
        assertTrue(medecinRepository.deleteMedecin(toAdd.getMedecin_id()));

    }

    @Test
    public void testDisplayMedecin() {
        Medecin toAdd = new Medecin(1, "adresse", "legalMention", "presentation", 10);
        medecinRepository.addMedecin(toAdd);
        assertNotNull(medecinRepository.displayMedecin(toAdd.getMedecin_id()));
        

        
    }

    @Test
    public void testFindAll() {
        List<Medecin> result = medecinRepository.findAll();
        assertNotNull(result.size());
    }

    @Test
    public void testModifyMedecin() {
        Medecin toAdd = new Medecin(1, "adresse", "legalMention", "presentation", 10);
        medecinRepository.addMedecin(toAdd);
        assertTrue(medecinRepository.modifyMedecin(toAdd)); 
        
    }
}
