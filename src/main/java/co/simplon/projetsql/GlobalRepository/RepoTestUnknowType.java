package co.simplon.projetsql.globalRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepoTestUnknowType <T> {

    protected String sqlQueryFind;
    protected Connection connection;
    

    

    public RepoTestUnknowType() {
        
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://simplon:1234@localhost:3306/DOCTOLIBIS");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public T find(Integer id){
    
        try {
            PreparedStatement stmt = connection.prepareStatement(sqlQueryFind);
            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                return instanciateType(result);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }
    
    protected T instanciateType(ResultSet result) {
        return null;      
    }
}
