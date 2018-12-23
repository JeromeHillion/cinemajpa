/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.laerce.cinema.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;

/**
 *
 * @author Gideon
 */
@Entity
@Table(name = "genres")
public class Genre {
    private long id;
    private String name;
    private List<Film> listFilm = new ArrayList<Film> ();
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id", nullable = false)

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    @Basic
    @Column(name = "name", nullable = false, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @ManyToMany
    @ JoinTable(name = "film_genre", joinColumns = { @JoinColumn(name = "genre_id")},
            inverseJoinColumns = {@JoinColumn(name="film_id")})

    public List<Film> getListFilm() {
        return listFilm;
    }

    public void setListFilm(List<Film> listFilm) {
        this.listFilm = listFilm;
    }
   
    
}
