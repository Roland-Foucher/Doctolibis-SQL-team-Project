package co.simplon.projetsql.repository;

import java.util.List;

import co.simplon.projetsql.entity.Role;

public interface IRoleRepository {
   
    List <Role> findAll();

    Role find(Integer id);

    boolean save(Role role);

    boolean update(Role role);

    boolean deleteById(Integer Id);
}
