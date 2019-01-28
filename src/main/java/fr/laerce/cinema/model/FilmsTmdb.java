package fr.laerce.cinema.model;


import org.checkerframework.common.aliasing.qual.Unique;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tmdb_movies")
public class FilmsTmdb {


    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String title;

    @NotNull
    @Unique
    private long idtmdb;

    public FilmsTmdb() {
    }

    public FilmsTmdb(String title, long idtmdb) {
        this.title = title;
        this.idtmdb = idtmdb;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getIdtmdb() {
        return idtmdb;
    }

    public void setIdtmdb(long idtmdb) {
        this.idtmdb = idtmdb;
    }
}
