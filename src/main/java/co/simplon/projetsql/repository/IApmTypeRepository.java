package co.simplon.projetsql.repository;

import java.util.List;

import co.simplon.projetsql.entity.ApmType;

public interface IApmTypeRepository {

    void addApmType(ApmType apmType);
    ApmType disPlayapmType(int id);
    void modifyApmType(ApmType apmType);
    void deleteApm(int id);
    List<ApmType>showListOfRoles();
    
}
