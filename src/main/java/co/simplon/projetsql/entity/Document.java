package co.simplon.projetsql.entity;

public class Document {
    private Integer doc_id;
    private Integer patient_id;
    private String name;

    /* constructors */

    public Document(Integer patient_id, String name) {
        this.patient_id = patient_id;
        this.name = name;
    }

    public Document(Integer doc_id, Integer patient_id, String name) {
        this.doc_id = doc_id;
        this.patient_id = patient_id;
        this.name = name;
    }

    public Document() {
    }

    /* getter/setter */

    public Integer getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(Integer doc_id) {
        this.doc_id = doc_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Integer patient_id) {
        this.patient_id = patient_id;
    }

    @Override
    public String toString() {
        return "Document [doc_id=" + doc_id + ", name=" + name + ", patient_id=" + patient_id + "]";
    }
}
