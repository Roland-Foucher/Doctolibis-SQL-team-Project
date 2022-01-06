package co.simplon.projetsql.repository;

import java.util.List;

import co.simplon.projetsql.entity.Role;

public interface IRoleRepository {
   
    List <Role> findAll();

    Role find(Integer id);

    void save(Role role);

    void update(Role role);

    void delete(Integer Id);
}
