package repository;

import java.util.List;

import co.simplon.projetsql.entity.Document;

public interface IDocumentRepository {
    List<Document> findAll();

    void addDocument();

    void modifyDocument();

    void deleteDocument();

    Document displayDocument();

}
