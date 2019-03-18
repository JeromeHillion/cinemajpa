package fr.laerce.cinema.dao;

import fr.laerce.cinema.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
    public static void saveUser(User user) {

    }
    public static void removeUser(User user) {

    }


    public User findAllByOrderByName();
}
