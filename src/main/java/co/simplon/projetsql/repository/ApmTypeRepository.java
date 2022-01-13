package co.simplon.projetsql.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.simplon.projetsql.entity.ApmType;


public class ApmTypeRepository implements IApmTypeRepository {

    
    private Connection connection;

    public ApmTypeRepository() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://simplon:1234@localhost:3306/DOCTOLIBIS");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public boolean addApmType(ApmType apmType) {
        try {

            if(apmType.getApmType_id() != null) {
                return addApmType(apmType);
            }
            PreparedStatement stmt = connection
            .prepareStatement("INSERT INTO apm_type (type) VALUES (?)", PreparedStatement.RETURN_GENERATED_KEYS);
           
            stmt.setString(1, apmType.getType());
        
            if(stmt.executeUpdate() == 1) {
                ResultSet result = stmt.getGeneratedKeys();
                result.next();
                apmType.setApmType_id(result.getInt(1));

                return true;
            }


        } catch (SQLException e) {
            
            e.printStackTrace();
        }



        return false;
    }

    @Override
    public ApmType disPlayapmType(int id) {
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM apm_type WHERE  apmType_id=?");
            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                return instanciateApmType(result);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean modifyApmType(ApmType apmType) {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement(
                            "UPDATE apm_type SET type=? WHERE apmType_id=?");
            stmt.setString(1, apmType.getType());              
            stmt.setInt(2, apmType.getApmType_id());
           

            return stmt.executeUpdate() == 1;

        } catch (SQLException e) {

            e.printStackTrace();
        }
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteApm(int id) {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("DELETE FROM apm_type WHERE apmType_id=?");
            stmt.setInt(1, id);
            return stmt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }

    @Override
    public List<ApmType> showListOfRoles() {
        try {

            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM apm_type");
            ResultSet result = stmt.executeQuery();
            List<ApmType> apmTypeList = new ArrayList<>();
            while (result.next()) {
                ApmType apmType = instanciateApmType(result);
                apmTypeList.add(apmType);

            }
            return apmTypeList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    
    private ApmType instanciateApmType(ResultSet result) {
        try {
            return new ApmType(result.getInt("apmType_id"),
                    result.getString("type"));
                
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public Connection getConnection() {
        return connection;
    }
    
    
}
