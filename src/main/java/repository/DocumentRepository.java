package repository;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.simplon.projetsql.entity.Document;

public class DocumentRepository implements IDocumentRepository {

    @Override
    public List<Document> findAll() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://simplon:1234@localhost:3306/DOCTOLIBIS");
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM document");
            ResultSet result = stmt.executeQuery();
            List<Document> documentList = new ArrayList<>();
            while (result.next()) {
                Document document = new Document(
                        result.getInt("doc_id"),
                        result.getInt("patient_id"),
                        result.getString("name"));
                documentList.add(document);
            }
            return documentList;
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addDocument() {
        // TODO Auto-generated method stub

    }

    @Override
    public void modifyDocument() {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteDocument() {
        // TODO Auto-generated method stub

    }

    @Override
    public Document displayDocument() {
        // TODO Auto-generated method stub
        return null;
    }

}
