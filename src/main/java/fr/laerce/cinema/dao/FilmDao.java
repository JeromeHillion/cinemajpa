package fr.laerce.cinema.dao;

import fr.laerce.cinema.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Component
public class FilmDao {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void save(Film f){
        entityManager.merge(f);
    }

    @Transactional
    public void delete(long id){
        Film film = entityManager.find (Film.class, id);
        if (film == null) {
            System.out.println("Ce film n'existe pas dans la BDD");
        } else {
            entityManager.remove(film);
        }
    }

    public void update(Long id, String titre)
    {
        Film fToUpdate = this.getById(id);
        fToUpdate.setTitre(titre);
    }


    public List<Film> getAll(){
        Query query = entityManager.createQuery("Select f from films f");
        return query.getResultList();
    }

    public Film getById(Long id){
        Film retVal = null;
        Query query = entityManager.createQuery("select f from films f where f.id = :id");
        query.setParameter("id", id);
        List<Film> films = query.getResultList();
        if(!films.isEmpty()){
            retVal = films.get(0);
        }
        return retVal;
    }
}
