package fr.laerce.cinema.service;


import fr.laerce.cinema.dao.UserDao;
import fr.laerce.cinema.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class UserManager {

    @Autowired
    private UserDao userDao;



    public User getbyId(long id) {
        return userDao.findById(id).get();
    }
        public static Iterable<User> getAll(){
            return Collections.singleton(userDao.findAllByOrderByName());
        }


    public Long saveUser (User user){
    UserDao.saveUser(user);
    return user.getId();
    }

    public String removeUser(User user){
    UserDao.removeUser(user);
    return user.getGivenname();
    }
    public static User getById(long id) {
        User user = null;
        return user.getId();
    }
}
