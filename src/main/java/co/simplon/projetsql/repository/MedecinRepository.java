package co.simplon.projetsql.repository;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.simplon.projetsql.entity.Medecin;

public class MedecinRepository implements IMedecinRepository {
    Connection connection;

    public MedecinRepository() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://simplon:1234@localhost:3306/DOCTOLIBIS");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Medecin> findAll() {
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM medecin");
            ResultSet result = stmt.executeQuery();
            List<Medecin> medecinList = new ArrayList<>();
            while (result.next()) {
                Medecin medecin = instanciateMedecin(result);
                medecinList.add(medecin);
            }
            return medecinList;
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addMedecin(Medecin medecin) {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement(
                            "INSERT INTO medecin (user_id, adress, legalMention, presentation, price) VALUES (?,?,?,?,?)",
                            PreparedStatement.RETURN_GENERATED_KEYS);
    
            stmt.setInt(1, medecin.getUser_id());
            stmt.setString(2, medecin.getAdresse());
            stmt.setString(3, medecin.getLegalMention());
            stmt.setString(4, medecin.getPresentation());
            stmt.setInt(5, medecin.getPrice());

            if (stmt.executeUpdate() == 1) {
                ResultSet result = stmt.getGeneratedKeys();
                result.next();
                medecin.setMedecin_id(result.getInt(1));

                return true;
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean modifyMedecin(Medecin medecin) {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement(
                            "UPDATE medecin SET user_id=?, adress=?, legalMention=?, presentation=?, price=? WHERE medecin_id=?");
            
            stmt.setInt(1, medecin.getUser_id());
            stmt.setString(2, medecin.getAdresse());
            stmt.setString(3, medecin.getLegalMention());
            stmt.setString(4, medecin.getPresentation());
            stmt.setInt(5, medecin.getPrice());
    
            stmt.setInt(6, medecin.getMedecin_id());

            return stmt.executeUpdate() == 1;

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean deleteMedecin(Integer id) {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("DELETE FROM medecin WHERE medecin_id=?");
            stmt.setInt(1, id);
            return stmt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public Medecin displayMedecin(Integer id) {
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM medecin WHERE medecin_id=?");
            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                return instanciateMedecin(result);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }

    private Medecin instanciateMedecin(ResultSet result) {
        try {
            return new Medecin(
                    result.getInt("medecin_id"),
                    result.getInt("user_id"),
                    result.getString("adress"),
                    result.getString("legalMention"),
                    result.getString("presentation"),
                    result.getInt("price"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public Connection getConnection() {
        return connection;
    }

    @Override
    public Medecin findByadress(String adress) {
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM medecin WHERE adress=?");
            stmt.setString(1, adress);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                return instanciateMedecin(result);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Medecin findBySpeciality(String speciality) {
       // TODO jonction a faire !
       return null;
    }

    @Override
    public Medecin findByPrice(int price) {
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM medecin WHERE price=?");
            stmt.setInt(1, price);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                return instanciateMedecin(result);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }

}
