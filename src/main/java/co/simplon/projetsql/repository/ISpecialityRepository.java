package co.simplon.projetsql.repository;

import java.util.List;

import co.simplon.projetsql.entity.Speciality;

public interface ISpecialityRepository {
    List<Speciality> findAll();

    boolean addSpeciality(Speciality speciality);

    boolean modifySpeciality(Speciality speciality);

    boolean deleteSpeciality(Integer id);

    Speciality displaySpeciality(Integer id);

}
