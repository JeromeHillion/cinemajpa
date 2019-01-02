package fr.laerce.cinema.dao;
import fr.laerce.cinema.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface PersonDao extends CrudRepository<Person,Long> {
     /*public Person findAllByImage_path(String img);*/
    public List<Person>findAllByOrderByIdAsc();
}
