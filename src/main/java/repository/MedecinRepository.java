package repository;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.simplon.projetsql.entity.Medecin;

public class MedecinRepository implements IMedecinRepository {

    @Override
    public List<Medecin> findAll() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://simplon:1234@localhost:3306/DOCTOLIBIS");
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM medecin");
            ResultSet result = stmt.executeQuery();
            List<Medecin> medecinList = new ArrayList<>();
            while (result.next()) {
                Medecin medecin = new Medecin(
                        result.getInt("medecin_id"),
                        result.getInt("user_id"),
                        result.getString("adresse"),
                        result.getString("legalMention"),
                        result.getString("speciality"),
                        result.getString("presentation"),
                        result.getInt("price"));
                medecinList.add(medecin);
            }
            return medecinList;
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addMedecin() {
        // TODO Auto-generated method stub

    }

    @Override
    public void modifyMedecin() {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteMedecin() {
        // TODO Auto-generated method stub

    }

    @Override
    public Medecin displayMedecin() {
        // TODO Auto-generated method stub
        return null;
    }

}
