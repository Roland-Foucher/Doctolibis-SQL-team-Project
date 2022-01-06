package co.simplon.projetsq.entity;

public class ApmType {
    
    private int apmType_id;
    private String type;

    // constructors
    public ApmType(int apmType_id, String type) {
        this.apmType_id = apmType_id;
        this.type = type;
    }

    public ApmType(String type) {
        this.type = type;
    }

    public ApmType() {
    }
        // getter&setter
    public int getApmType_id() {
        return apmType_id;
    }
    public void setApmType_id(int apmType_id) {
        this.apmType_id = apmType_id;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
