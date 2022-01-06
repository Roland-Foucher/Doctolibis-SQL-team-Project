package co.simplon.projetsql.entity;

public class Medecin {
    private int medecin_id;
    private int user_id;
    private String adresse;
    private String legalMention;
    private String speciality;
    private String presentation;
    private int price;

    /* constructors */

    public Medecin(int user_id, String adresse, String legalMention, String speciality, String presentation,
            int price) {
        this.user_id = user_id;
        this.adresse = adresse;
        this.legalMention = legalMention;
        this.speciality = speciality;
        this.presentation = presentation;
        this.price = price;
    }

    public Medecin(int medecin_id, int user_id, String adresse, String legalMention, String speciality,
            String presentation, int price) {
        this.medecin_id = medecin_id;
        this.user_id = user_id;
        this.adresse = adresse;
        this.legalMention = legalMention;
        this.speciality = speciality;
        this.presentation = presentation;
        this.price = price;
    }

    public Medecin() {
    }

    /* getter/setter */

    public int getMedecin_id() {
        return medecin_id;
    }

    public void setMedecin_id(int medecin_id) {
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

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
