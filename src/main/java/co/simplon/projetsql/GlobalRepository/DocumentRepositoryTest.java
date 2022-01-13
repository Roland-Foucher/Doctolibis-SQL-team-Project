package co.simplon.projetsql.globalRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.simplon.projetsql.entity.Document;

public class DocumentRepositoryTest extends RepoTestUnknowType <Document> {

    public DocumentRepositoryTest() {
        super();
        this.sqlQueryFind = "SELECT * FROM document WHERE doc_id=?";
    }

    @Override
    protected Document instanciateType(ResultSet result) {
        try {
            return new Document(
                    result.getInt("doc_id"),
                    result.getInt("patient_id"),
                    result.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    

 
    
}
