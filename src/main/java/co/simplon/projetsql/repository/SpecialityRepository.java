package co.simplon.projetsql.repository;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.simplon.projetsql.entity.Speciality;

public class SpecialityRepository implements ISpecialityRepository {
    Connection connection;

    public SpecialityRepository() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://simplon:1234@localhost:3306/DOCTOLIBIS");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Speciality> findAll(Integer id) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://simplon:1234@localhost:3306/DOCTOLIBIS");
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM speciality");
            ResultSet result = stmt.executeQuery();
            List<Speciality> specialityList = new ArrayList<>();
            while (result.next()) {
                Speciality speciality = instanciateSpeciality(result);
                specialityList.add(speciality);
            }
            return specialityList;
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addSpeciality(Speciality speciality) {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement(
                            "INSERT INTO speciality (spe_id, name) VALUES (?,?)",
                            PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, speciality.getSpe_id());
            stmt.setString(2, speciality.getName());

            if (stmt.executeUpdate() == 1) {
                ResultSet result = stmt.getGeneratedKeys();
                result.next();
                speciality.setSpe_id(result.getInt(1));

                return true;
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean modifySpeciality(Speciality speciality) {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement(
                            "UPDATE speciality SET spe_id=?, name=? WHERE spe_id=?");
            stmt.setInt(1, speciality.getSpe_id());
            stmt.setString(2, speciality.getName());

            return stmt.executeUpdate() == 1;

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean deleteSpeciality(Integer id) {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("DELETE FROM speciality WHERE spe_id=?");
            stmt.setInt(1, id);
            return stmt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public Speciality displaySpeciality(Integer id) {
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM speciality WHERE spe_id=?");
            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                return instanciateSpeciality(result);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }

    private Speciality instanciateSpeciality(ResultSet result) {
        try {
            return new Speciality(
                    result.getInt("spe_id"),
                    result.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

}
