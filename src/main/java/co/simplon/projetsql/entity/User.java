package co.simplon.projetsql.entity;

/**
 * class of global users entity.
 * comport : full name, first name, email, password and id of the user
 */
public class User {

    private Integer user_id;
    private String fname;
    private String lname;
    private String email;
    private String password;
    
    //
    // contructors
    //

    public User(Integer user_id, String fname, String lname, String email, String password) {
        this.user_id = user_id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
    }
    public User(String fname, String lname, String email, String password) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
    }
    public User() {
    }

    //
    // getters + setters
    //

    public Integer getUser_id() {
        return user_id;
    }
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getLname() {
        return lname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "User [email=" + email + ", fname=" + fname + ", lname=" + lname + ", password=" + password
                + ", user_id=" + user_id + "]";
    }


}
