package co.simplon.projetsql.globalRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.simplon.projetsql.entity.User;

public class UserRepositoryTest extends RepoTestUnknowType <User> {

    public UserRepositoryTest() {
        super();
        this.sqlQueryFind = "SELECT * FROM users WHERE user_id=?";
    }

    @Override
    protected User instanciateType(ResultSet result){
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
