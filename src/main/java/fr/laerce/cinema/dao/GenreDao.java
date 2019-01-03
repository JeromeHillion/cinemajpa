package fr.laerce.cinema.dao;

import fr.laerce.cinema.model.Genre;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GenreDao extends CrudRepository<Genre, Long> {
    public List<Genre> findAllByOrderByIdAsc();
}