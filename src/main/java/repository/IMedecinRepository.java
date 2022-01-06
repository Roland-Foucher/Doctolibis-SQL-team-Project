package repository;

import java.util.List;

import co.simplon.projetsql.entity.Medecin;

public interface IMedecinRepository {
    List<Medecin> findAll();

    void addMedecin();

    void modifyMedecin();

    void deleteMedecin();

    Medecin displayMedecin();

}
