package co.simplon.projetsql.entity;

/**
 * class with the different roles that can have a user 
 * role_id = id of the role to link user
 * role = name of the role (admin, medecin, patient)
 */
public class Role {

    private int role_id;
    private String role;

    //
    // constructors
    //

    public Role() {
    }
    public Role(String role) {
        this.role = role;
    }
    public Role(int role_id, String role) {
        this.role_id = role_id;
        this.role = role;
    }

    //
    // getters + setters
    //

    public int getRole_id() {
        return role_id;
    }
    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

}
