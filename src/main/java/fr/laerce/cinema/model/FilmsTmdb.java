package fr.laerce.cinema.model;


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
    private long tmdbid;

    public FilmsTmdb( String title, long tmdbid) {
        this.title = title;
        this.tmdbid = tmdbid;
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

    public long getTmdbid() {
        return tmdbid;
    }

    public void setTmdbid(long tmdbid) {
        this.tmdbid = tmdbid;
    }

}
