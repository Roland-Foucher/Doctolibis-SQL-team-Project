package co.simplon.projetsq.entity;

import java.time.LocalDate;

public class Appointment {

    private int apm_id;
    private LocalDate date;

    // constructors

    public Appointment(LocalDate date) {
        this.date = date;
    }

    public Appointment(int apm_id, LocalDate date) {
        this.apm_id = apm_id;
        this.date = date;
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

}
