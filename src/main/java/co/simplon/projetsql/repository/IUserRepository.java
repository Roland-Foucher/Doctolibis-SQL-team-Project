package co.simplon.projetsql.repository;

import java.util.List;

import co.simplon.projetsql.entity.User;

public interface IUserRepository {

    List<User> findAll();

    User find(Integer id);

    boolean save(User user);

    boolean update(User user);

    boolean deleteById(Integer Id);

    User findByLastName(String name);

    User findByMedecinId(Integer id);

    User findUserWithPatient(Integer id);
}
