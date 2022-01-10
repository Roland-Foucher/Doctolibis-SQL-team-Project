package co.simplon.projetsql.repository;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.simplon.projetsql.entity.User;

public class UserRepositoryTest {


    private IUserRepository userRepository;

    @Before
    public void setUp() {
        userRepository = new UserRepository();

        try {

            userRepository.getConnection().setAutoCommit(false);
           
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        try {
            //Après chaque test on "rollback" la base de données, c'est à dire qu'on
            //annule les modifications qu'on a possiblement faites dessus
            userRepository.getConnection().rollback();
            userRepository.getConnection().setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testAddUser() {
        User toAdd = new User("fname", "lname", "email", "password", "phoneNumber");
        assertTrue(userRepository.save(toAdd));

    }

    @Test
    public void testDeleteUser() {
        User toAdd = new User("fname", "lname", "email", "password", "phoneNumber");
        userRepository.save(toAdd);
        assertTrue(userRepository.deleteById(toAdd.getUser_id()));

    }

    @Test
    public void testDisplayUser() {
        User toAdd = new User("fname", "lname", "email", "password", "phoneNumber");
        userRepository.save(toAdd);
        assertNotNull(userRepository.find(toAdd.getUser_id()));
        

        
    }

    @Test
    public void testFindAll() {
        User toAdd = new User("fname", "lname", "email", "password", "phoneNumber");
        userRepository.save(toAdd);
        List<User> result = userRepository.findAll();
        assertNotEquals(0, result.size());
    }

    @Test
    public void testModifyUser() {
        User toAdd = new User("fname", "lname", "email", "password", "phoneNumber");
        userRepository.save(toAdd);
        assertTrue(userRepository.update(toAdd)); 
        
    }
}
