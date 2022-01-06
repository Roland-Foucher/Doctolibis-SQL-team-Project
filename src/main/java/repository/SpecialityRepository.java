package repository;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.simplon.projetsql.entity.Speciality;

public class SpecialityRepository implements ISpecialityRepository {

    @Override
    public List<Speciality> findAll() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://simplon:1234@localhost:3306/DOCTOLIBIS");
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM speciality");
            ResultSet result = stmt.executeQuery();
            List<Speciality> specialityList = new ArrayList<>();
            while (result.next()) {
                Speciality speciality = new Speciality(
                        result.getInt("spe_id"),
                        result.getString("name"));
                specialityList.add(speciality);
            }
            return specialityList;
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addSpeciality() {
        // TODO Auto-generated method stub

    }

    @Override
    public void modifySpeciality() {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteSpeciality() {
        // TODO Auto-generated method stub

    }

    @Override
    public Speciality displaySpeciality() {
        // TODO Auto-generated method stub
        return null;
    }

}
