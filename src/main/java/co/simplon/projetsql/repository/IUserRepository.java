package co.simplon.projetsql.repository;

import java.util.List;

import co.simplon.projetsql.entity.User;

public interface IUserRepository {

    List <User> findAll();

    User find(Integer id);

    void save(User user);

    void update(User user);
    
    void delete(Integer Id);
    // void connectUser();
    // void subscribeUser();
}
