package co.simplon.projetsql.repository;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.simplon.projetsql.entity.Role;

public class RoleRepositoryTest {

    private IRoleRepository roleRepository;

    @Before
    public void setUp() {
        roleRepository = new RoleRepository();

        try {

            roleRepository.getConnection().setAutoCommit(false);
           
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        try {
            //Après chaque test on "rollback" la base de données, c'est à dire qu'on
            //annule les modifications qu'on a possiblement faites dessus
            roleRepository.getConnection().rollback();
            roleRepository.getConnection().setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testAddRole() {
        Role toAdd = new Role("role");
        assertTrue(roleRepository.save(toAdd));

    }

    @Test
    public void testDeleteRole() {
        Role toAdd = new Role("role");
        roleRepository.save(toAdd);
        assertTrue(roleRepository.deleteById(toAdd.getRole_id()));

    }

    @Test
    public void testDisplayRole() {
        Role toAdd = new Role("role");
        roleRepository.save(toAdd);
        assertNotNull(roleRepository.find(toAdd.getRole_id()));
        

        
    }

    @Test
    public void testFindAll() {
        Role toAdd = new Role("role");
        roleRepository.save(toAdd);
        List<Role> result = roleRepository.findAll();
        assertNotEquals(0, result.size());
    }

    @Test
    public void testModifyRole() {
        Role toAdd = new Role("role");
        roleRepository.save(toAdd);
        assertTrue(roleRepository.update(toAdd)); 
        
    }
}
