package fr.laerce.cinema.service;

import fr.laerce.cinema.dao.PersonDao;
import fr.laerce.cinema.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonManager {
    @Autowired
    PersonDao personDao;

    public Iterable<Person> getAll(){
        return personDao.findAll();
    }
}