package co.simplon.projetsql.repository;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.simplon.projetsql.entity.ApmType;

public class ApmTypeRepositoryTest {

    private IApmTypeRepository apmTypeRepository;

    @Before
    public void setUp() {
        apmTypeRepository = new ApmTypeRepository();

        try {
            apmTypeRepository.getConnection().setAutoCommit(false);
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        try {
            apmTypeRepository.getConnection().rollback();
            apmTypeRepository.getConnection().setAutoCommit(true);
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    @Test
    public void testAddApmType() {
        ApmType apmType = new ApmType("video");
        assertTrue(apmTypeRepository.addApmType(apmType));

    }

    @Test
    public void testDeleteApm() {
        ApmType apmType = new ApmType("video");
        apmTypeRepository.addApmType(apmType);
        assertTrue(apmTypeRepository.deleteApm(apmType.getApmType_id()));

    }

    @Test
    public void testDisPlayapmType() {
        ApmType apmType = new ApmType("video");
        apmTypeRepository.addApmType(apmType);
        assertNotNull(apmTypeRepository.disPlayapmType(apmType.getApmType_id()));

    }

    @Test
    public void testModifyApmType() {
        ApmType apmType = new ApmType("video");
        apmTypeRepository.addApmType(apmType);
        assertTrue(apmTypeRepository.modifyApmType(apmType));

    }

    @Test
    public void testShowListOfRoles() {
        List<ApmType> list = apmTypeRepository.showListOfRoles();
        assertNotEquals(0, list.size());
    }
}
