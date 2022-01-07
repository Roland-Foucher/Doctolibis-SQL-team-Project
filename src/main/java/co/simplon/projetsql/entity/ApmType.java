package co.simplon.projetsql.entity;

public class ApmType {
    
    private Integer apmType_id;
    private String type;

    // constructors
    public ApmType(Integer apmType_id, String type) {
        this.apmType_id = apmType_id;
        this.type = type;
    }

    public ApmType(String type) {
        this.type = type;
    }

    public ApmType() {
    }
        // getter&setter
    public Integer getApmType_id() {
        return apmType_id;
    }
    public void setApmType_id(Integer apmType_id) {
        this.apmType_id = apmType_id;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
