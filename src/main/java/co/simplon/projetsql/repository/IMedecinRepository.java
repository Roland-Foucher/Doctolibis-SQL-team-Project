package co.simplon.projetsql.repository;

import java.util.List;

import co.simplon.projetsql.entity.Medecin;

public interface IMedecinRepository {
    List<Medecin> findAll(Integer id);

    boolean addMedecin(Medecin medecin);

    boolean modifyMedecin(Medecin medecin);

    boolean deleteMedecin(Integer id);

    Medecin displayMedecin(Integer id);

}
