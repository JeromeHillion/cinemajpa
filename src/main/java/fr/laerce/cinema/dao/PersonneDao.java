package fr.laerce.cinema.dao;
import fr.laerce.cinema.model.Personne;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface PersonneDao extends CrudRepository<Personne,Long> {
     public Personne findAllByImage_path(String img);
}
