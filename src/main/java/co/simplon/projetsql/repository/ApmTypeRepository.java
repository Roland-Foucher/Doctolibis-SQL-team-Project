package co.simplon.projetsql.repository;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;

import co.simplon.projetsql.entity.ApmType;
import co.simplon.projetsql.entity.Appointment;

public class ApmTypeRepository implements IApmTypeRepository {

    @Override
    public void addApmType(ApmType apmType) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public ApmType disPlayapmType(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void modifyApmType(ApmType apmType) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteApm(int id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<ApmType> showListOfRoles() {
        // TODO Auto-generated method stub
        return null;
    }

    
    
}
