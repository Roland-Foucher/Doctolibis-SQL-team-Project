package co.simplon.projetsql.entity;

public class Patient {
    private Integer patient_id;
    private Integer user_id;
    private Integer phoneNumber;
    private Integer secuNumber;

    /* constructors */

    public Patient(Integer user_id, Integer phoneNumber, Integer secuNumber) {
        this.user_id = user_id;
        this.phoneNumber = phoneNumber;
        this.secuNumber = secuNumber;
    }

    public Patient(Integer patient_id, Integer user_id, Integer phoneNumber, Integer secuNumber) {
        this.patient_id = patient_id;
        this.user_id = user_id;
        this.phoneNumber = phoneNumber;
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

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getSecuNumber() {
        return secuNumber;
    }

    public void setSecuNumber(Integer secuNumber) {
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
        return "Patient [patient_id=" + patient_id + ", phoneNumber=" + phoneNumber + ", secuNumber=" + secuNumber
                + ", user_id=" + user_id + "]";
    }

}
