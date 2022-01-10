package co.simplon.projetsql.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.simplon.projetsql.entity.Role;

public class RoleRepository implements IRoleRepository {

    private Connection connection;

    public RoleRepository() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://simplon:1234@localhost:3306/DOCTOLIBIS");
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public List<Role> findAll() {
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM roles");
            ResultSet result = stmt.executeQuery();
            List <Role> roleList = new ArrayList<>();
            while(result.next()){
                Role role = instanciateRole(result);
                roleList.add(role);
            }
            return roleList;
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Role find(Integer id) {
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM roles WHERE role_id=?");
            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                return instanciateRole(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(Role role) {
        try {
            if(role.getRole_id() != null) {
                return update(role);
            }
            PreparedStatement stmt = connection
                .prepareStatement("INSERT INTO roles (role) VALUES (?)", PreparedStatement.RETURN_GENERATED_KEYS);

            stmt.setString(1, role.getRole());

            if(stmt.executeUpdate() == 1) {
                ResultSet result = stmt.getGeneratedKeys();
                result.next();
                role.setRole_id((result.getInt(1)));
                return true;
            }


        } catch (SQLException e) {
            
            e.printStackTrace();
        }

        return false;

    }
    

    @Override
    public boolean update(Role role) {
        try {
            PreparedStatement stmt = connection
                .prepareStatement("UPDATE roles SET role=? WHERE role_id=?");

            stmt.setString(1, role.getRole());
            stmt.setInt(2, role.getRole_id());
        
            return stmt.executeUpdate() == 1;

        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        try {
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM roles WHERE role_id=?");
            stmt.setInt(1, id);
            return stmt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }


    private Role instanciateRole(ResultSet result){
        try {
            return new Role(result.getInt("role_id"), 
                            result.getString("role"));
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        return null;
    }

    public Connection getConnection() {
        return connection;
    }

    
}
