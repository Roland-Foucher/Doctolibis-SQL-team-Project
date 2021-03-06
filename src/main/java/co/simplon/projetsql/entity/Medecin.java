package co.simplon.projetsql.entity;

import java.util.List;

public class Medecin {
    
    private Integer medecin_id;
    private Integer user_id;
    private String adresse;
    private String legalMention;
    private String presentation;
    private Integer price;
    private List <Patient> patientsList;


    /* constructors */

    public Medecin(Integer user_id, String adresse, String legalMention, String presentation,
            Integer price) {
        this.user_id = user_id;
        this.adresse = adresse;
        this.legalMention = legalMention;
        this.presentation = presentation;
        this.price = price;
    }


    public Medecin(Integer medecin_id, Integer user_id, String adresse, String legalMention,
            String presentation, Integer price) {
        this.medecin_id = medecin_id;
        this.user_id = user_id;
        this.adresse = adresse;
        this.legalMention = legalMention;
        this.presentation = presentation;
        this.price = price;
    }

    public Medecin() {
    }

    /* getter/setter */

    

    public Integer getMedecin_id() {
        return medecin_id;
    }

    public void setMedecin_id(Integer medecin_id) {
        this.medecin_id = medecin_id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getLegalMention() {
        return legalMention;
    }

    public void setLegalMention(String legalMention) {
        this.legalMention = legalMention;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }


    @Override
    public String toString() {
        return "Medecin [adresse=" + adresse + ", legalMention=" + legalMention + ", medecin_id=" + medecin_id
                + ", presentation=" + presentation + ", price=" + price
                + ", user_id=" + user_id + "]";
    }


    public List<Patient> getPatientsList() {
        return patientsList;
    }


    public void setPatientsList(List<Patient> patientsList) {
        this.patientsList = patientsList;
    }
    


    
}
