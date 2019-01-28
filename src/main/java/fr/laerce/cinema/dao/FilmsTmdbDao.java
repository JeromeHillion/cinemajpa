package fr.laerce.cinema.dao;

import fr.laerce.cinema.model.FilmsTmdb;
import org.springframework.data.repository.CrudRepository;

public interface FilmsTmdbDao extends CrudRepository<FilmsTmdb, Long>{
    public  FilmsTmdb findByIdtmdb(long id);
}
