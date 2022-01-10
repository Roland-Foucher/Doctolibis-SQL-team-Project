package co.simplon.projetsql.repository;

import org.junit.Test;

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

    }

    @Test
    public void testDeletePatient() {

    }

    @Test
    public void testDisplayPatient() {

    }

    @Test
    public void testFindAll() {

    }

    @Test
    public void testModifyPatient() {

    }
}
