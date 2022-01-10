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

    private Connection connection;
    

    public UserRepository() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://simplon:1234@localhost:3306/DOCTOLIBIS");
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findAll() {
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM users");
            ResultSet result = stmt.executeQuery();
            List <User> userList = new ArrayList<>();
            while(result.next()){
                User user = instanciateUser(result);
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
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM users WHERE user_id=?");
            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                return instanciateUser(result);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(User user) {
        try {
            
            if(user.getUser_id() != null) {
                return update(user);
            }
            PreparedStatement stmt = connection
            .prepareStatement("INSERT INTO users (fname,lname,email,password, phoneNumber) VALUES (?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);

            stmt.setString(1, user.getFname());
            stmt.setString(2, user.getLname());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassword());
            stmt.setString(5, user.getPhoneNumber());



            if(stmt.executeUpdate() == 1) {
                ResultSet result = stmt.getGeneratedKeys();
                result.next();
                user.setUser_id(result.getInt(1));

                return true;
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean update(User user) {
        try {
            PreparedStatement stmt = connection
                .prepareStatement("UPDATE users SET fname=?, lname=?, email=?, password=?, phoneNumber=? WHERE user_id=?");
            stmt.setString(1, user.getFname());
            stmt.setString(2, user.getLname());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassword());
            stmt.setString(4, user.getPhoneNumber());


            stmt.setInt(5, user.getUser_id());
            
            return stmt.executeUpdate() == 1;

        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {

        try {
            PreparedStatement stmt = connection
            .prepareStatement("DELETE FROM users WHERE user_id=?");
            stmt.setInt(1, id);
            return stmt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    private User instanciateUser(ResultSet result){
        try {
            return new User(result.getInt("user_id"), 
                            result.getString("fname"), 
                            result.getString("lname"), 
                            result.getString("email"), 
                            result.getString("password"),
                            result.getString("phoneNumber"));
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        return null;
    }           
    
}
