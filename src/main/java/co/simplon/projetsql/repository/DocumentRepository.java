package co.simplon.projetsql.repository;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.simplon.projetsql.entity.Document;

public class DocumentRepository implements IDocumentRepository {
    Connection connection;

    public DocumentRepository() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://simplon:1234@localhost:3306/DOCTOLIBIS");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Document> findAll() {
        try {

            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM document");
            ResultSet result = stmt.executeQuery();
            List<Document> documentList = new ArrayList<>();
            while (result.next()) {
                Document document = instanciateDocumet(result);
                documentList.add(document);
            }
            return documentList;
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addDocument(Document document) {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("INSERT INTO document (patient_id, name) VALUES (?,?)",
                            PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, document.getPatient_id());
            stmt.setString(2, document.getName());

            if (stmt.executeUpdate() == 1) {
                ResultSet result = stmt.getGeneratedKeys();
                result.next();
                document.setDoc_id(result.getInt(1));

                return true;
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;

    }

    @Override
    public boolean modifyDocument(Document document) {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("UPDATE document SET patient_id=?, name=? WHERE doc_id=?");
            
            stmt.setInt(1, document.getPatient_id());
            stmt.setString(2, document.getName());
            stmt.setInt(3, document.getDoc_id());

            return stmt.executeUpdate() == 1;

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean deleteDocument(Integer id) {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("DELETE FROM document WHERE doc_id=?");
            stmt.setInt(1, id);
            return stmt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public Document displayDocument(Integer id) {
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM document WHERE doc_id=?");
            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                return instanciateDocumet(result);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }

    private Document instanciateDocumet(ResultSet result) {
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

    public Connection getConnection() {
        return connection;
    }
}
