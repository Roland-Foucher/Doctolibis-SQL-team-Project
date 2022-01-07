package co.simplon.projetsql.repository;

import java.util.List;

import co.simplon.projetsql.entity.Document;

public interface IDocumentRepository {
    List<Document> findAll(Integer id);

    boolean addDocument(Document document);

    boolean modifyDocument(Document document);

    boolean deleteDocument(Integer id);

    Document displayDocument(Integer id);

}
