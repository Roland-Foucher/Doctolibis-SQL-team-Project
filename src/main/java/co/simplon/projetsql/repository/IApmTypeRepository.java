package co.simplon.projetsql.repository;

import java.sql.Connection;
import java.util.List;

import co.simplon.projetsql.entity.ApmType;

public interface IApmTypeRepository {

    boolean addApmType(ApmType apmType);
    ApmType disPlayapmType(int id);
    boolean modifyApmType(ApmType apmType);
    boolean deleteApm(int id);
    List<ApmType>showListOfRoles();
    Connection getConnection();
    
}
