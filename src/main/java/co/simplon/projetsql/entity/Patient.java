package co.simplon.projetsql.entity;


public class Patient extends User {
    private Integer patient_id;
    private Integer user_id;
    private String secuNumber;


    /* constructors */

    public Patient(Integer user_id, String secuNumber) {
        this.user_id = user_id;
        this.secuNumber = secuNumber;
    }

    public Patient(Integer patient_id, Integer user_id, String secuNumber) {
        this.patient_id = patient_id;
        this.user_id = user_id;
        this.secuNumber = secuNumber;
    }

    public Patient() {
    }

    /* getter/setter */

    public Integer getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Integer patient_id) {
        this.patient_id = patient_id;
    }

    public String getSecuNumber() {
        return secuNumber;
    }

    public void setSecuNumber(String secuNumber) {
        this.secuNumber = secuNumber;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Patient [patient_id=" + patient_id +  ", secuNumber=" + secuNumber
                + ", user_id=" + user_id + "]";
    }

}
