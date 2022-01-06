package co.simplon.projetsql.entity;

public class Speciality {
    private int spe_id;
    private String name;

    /* constructors */

    public Speciality(String name) {
        this.name = name;
    }

    public Speciality() {
    }

    public Speciality(int spe_id, String name) {
        this.spe_id = spe_id;
        this.name = name;
    }

    /* getter/setter */

    public int getSpe_id() {
        return spe_id;
    }

    public void setSpe_id(int spe_id) {
        this.spe_id = spe_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
