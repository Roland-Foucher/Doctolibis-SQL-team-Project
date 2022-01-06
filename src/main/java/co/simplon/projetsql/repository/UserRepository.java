package co.simplon.projetsql.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.simplon.projetsql.entity.User;

public class UserRepository implements IUserRepository {

    @Override
    public List<User> findAll() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://simplon:1234@localhost:3306/DOCTOLIBIS");
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM users");
            ResultSet result = stmt.executeQuery();
            List <User> userList = new ArrayList<>();
            while(result.next()){
                User user = new User(   result.getInt("user_id"), 
                                        result.getString("fname"), 
                                        result.getString("lname"), 
                                        result.getString("email"), 
                                        result.getString("password"));
                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User find(Integer id) {
        return null;
    }

    @Override
    public void save(User user) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update(User user) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(Integer Id) {
        // TODO Auto-generated method stub
        
    }
    
}
