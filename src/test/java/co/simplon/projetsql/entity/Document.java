package co.simplon.projetsql.entity;

public class Document {
    private int doc_id;
    private String name;

    /* constructors */

    public Document(int doc_id, String name) {
        this.doc_id = doc_id;
        this.name = name;
    }

    public Document(String name) {
        this.name = name;
    }

    public Document() {
    }

    /* getter/setter */

    public int getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(int doc_id) {
        this.doc_id = doc_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
