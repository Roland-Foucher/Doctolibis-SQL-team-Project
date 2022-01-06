package co.simplon.projetsql.entity;

public class Patient {
    private int patient_id;
    private int phoneNumber;
    private int secuNumber;

    /* constructors */

    public Patient(int patient_id, int phoneNumber, int secuNumber) {
        this.patient_id = patient_id;
        this.phoneNumber = phoneNumber;
        this.secuNumber = secuNumber;
    }

    public Patient(int phoneNumber, int secuNumber) {
        this.phoneNumber = phoneNumber;
        this.secuNumber = secuNumber;
    }

    public Patient() {
    }

    /* getter/setter */

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSecuNumber() {
        return secuNumber;
    }

    public void setSecuNumber(int secuNumber) {
        this.secuNumber = secuNumber;
    }

}
