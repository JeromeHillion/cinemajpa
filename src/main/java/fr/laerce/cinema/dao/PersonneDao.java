package fr.laerce.cinema.dao;

import fr.laerce.cinema.model.Film;
import fr.laerce.cinema.model.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonneDao {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void save(Personne p){entityManager.persist(p);
    }
    public void delete(long id){
        Personne personne = entityManager.find(Personne.class, id);
    }


    public List<Personne> getAll(){
      Query query = entityManager.createQuery("SELECT p from Personne p");
      return query.getResultList();
    }

    public Personne getById(long id){
        Personne retVal = null;
        Query query = entityManager.createQuery("select p from Personne p where p.id = :id");
        query.setParameter("id", id);
        List<Personne> personnes = query.getResultList();
        if (!personnes.isEmpty()){
            retVal = personnes.get(0);
        }
        return retVal;
    }


}
