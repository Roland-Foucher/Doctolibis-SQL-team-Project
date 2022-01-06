package repository;

import java.util.List;

import co.simplon.projetsql.entity.Speciality;

public interface ISpecialityRepository {
    List<Speciality> findAll();

    void addSpeciality();

    void modifySpeciality();

    void deleteSpeciality();

    Speciality displaySpeciality();

}
