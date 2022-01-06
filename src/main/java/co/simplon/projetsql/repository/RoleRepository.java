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

    @Override
    public List<Role> findAll() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://simplon:1234@localhost:3306/DOCTOLIBIS");
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM roles");
            ResultSet result = stmt.executeQuery();
            List <Role> roleList = new ArrayList<>();
            while(result.next()){
                Role role = new Role(result.getInt("role_id"), result.getString("role"));
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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(Role role) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update(Role role) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(Integer Id) {
        // TODO Auto-generated method stub
        
    }
    
}
