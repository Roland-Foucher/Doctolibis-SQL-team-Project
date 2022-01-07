package co.simplon.projetsql.entity;

import java.time.LocalDate;

public class Appointment {

    private Integer apm_id;
    private LocalDate date;
    private Integer patient_id;
    private Integer medecin_id;
    private Integer apmType_id;

    // constructors

   

   

    public Appointment(LocalDate date, Integer patient_id, Integer medecin_id, Integer apmType_id) {
        this.date = date;
        this.patient_id = patient_id;
        this.medecin_id = medecin_id;
        this.apmType_id = apmType_id;
    }



    public Appointment(Integer apm_id, LocalDate date, Integer patient_id, Integer medecin_id, Integer apmType_id) {
        this.apm_id = apm_id;
        this.date = date;
        this.patient_id = patient_id;
        this.medecin_id = medecin_id;
        this.apmType_id = apmType_id;
    }

 

    public Appointment() {
    }

    // getter&setter

    public Integer getApm_id() {
        return apm_id;
    }

    public void setApm_id(Integer apm_id) {
        this.apm_id = apm_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Integer patient_id) {
        this.patient_id = patient_id;
    }

    public Integer getMedecin_id() {
        return medecin_id;
    }

    public void setMedecin_id(Integer medecin_id) {
        this.medecin_id = medecin_id;
    }

    public Integer getApmType_id() {
        return apmType_id;
    }

    public void setApmType_id(Integer apmType_id) {
        this.apmType_id = apmType_id;
    }

}
