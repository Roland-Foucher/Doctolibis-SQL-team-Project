package co.simplon.projetsql.repository;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.simplon.projetsql.entity.Document;

public class DocumentRepositoryTest {

    private IDocumentRepository documentRepository;

    @Before
    public void setUp() {
        documentRepository = new DocumentRepository();

        try {

            documentRepository.getConnection().setAutoCommit(false);
           
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        try {
            //Après chaque test on "rollback" la base de données, c'est à dire qu'on
            //annule les modifications qu'on a possiblement faites dessus
            documentRepository.getConnection().rollback();
            documentRepository.getConnection().setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Test
    public void testAddDocument() {
        Document toAdd = new Document(1, "name");
        assertTrue(documentRepository.addDocument(toAdd));

    }

    @Test
    public void testDeleteDocument() {
        Document toAdd = new Document(1, "name");
        documentRepository.addDocument(toAdd);
        assertTrue(documentRepository.deleteDocument(toAdd.getDoc_id()));

    }

    @Test
    public void testDisplayDocument() {
        Document toAdd = new Document(1, "name");
        documentRepository.addDocument(toAdd);
        assertNotNull(documentRepository.displayDocument(toAdd.getDoc_id()));
        

        
    }

    @Test
    public void testFindAll() {
        Document toAdd = new Document(1, "name");
        documentRepository.addDocument(toAdd);
        List<Document> result = documentRepository.findAll();
        assertNotEquals(0,result.size());
    }

    @Test
    public void testModifyDocument() {
        Document toAdd = new Document(1, "name");
        documentRepository.addDocument(toAdd);
        assertTrue(documentRepository.modifyDocument(toAdd)); 
        
    }
}

