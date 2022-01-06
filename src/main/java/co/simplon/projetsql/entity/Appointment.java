package co.simplon.projetsql.entity;

import java.time.LocalDate;

public class Appointment {

    private int apm_id;
    private LocalDate date;
    private int patient_id;
    private int medecin_id;
    private int apmType_id;

    // constructors

   

   

    public Appointment(int apm_id, LocalDate date, int patient_id, int medecin_id, int apmType_id) {
        this.apm_id = apm_id;
        this.date = date;
        this.patient_id = patient_id;
        this.medecin_id = medecin_id;
        this.apmType_id = apmType_id;
    }

    public Appointment(LocalDate date, int patient_id, int medecin_id, int apmType_id) {
        this.date = date;
        this.patient_id = patient_id;
        this.medecin_id = medecin_id;
        this.apmType_id = apmType_id;
    }

    public Appointment() {
    }

    // getter&setter

    public int getApm_id() {
        return apm_id;
    }

    public void setApm_id(int apm_id) {
        this.apm_id = apm_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public int getMedecin_id() {
        return medecin_id;
    }

    public void setMedecin_id(int medecin_id) {
        this.medecin_id = medecin_id;
    }

    public int getApmType_id() {
        return apmType_id;
    }

    public void setApmType_id(int apmType_id) {
        this.apmType_id = apmType_id;
    }

}
