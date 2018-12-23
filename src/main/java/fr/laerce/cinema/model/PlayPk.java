/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.laerce.cinema.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;

/**
 *
 * @author Gideon
 */
public class PlayPk implements Serializable {
    @Column(name="person_id")
    private Long personPlay;
     @Column(name="film_id")
    private Long filmPlay;

    public PlayPk(Long personPlay, Long filmPlay) {
        this.personPlay = personPlay;
        this.filmPlay = filmPlay;
    }
        public Long getPerson_id() {
        return personPlay;
    }
    public void setPerson_id(Long person_id) {
        this.personPlay = person_id;
    }

    public Long getFilm_id() {
        return filmPlay;
    }

    public void setFilm_id(Long film_id) {
        this.filmPlay= film_id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayPk)) return false;
        PlayPk playPk = (PlayPk) o;
        return Objects.equals (personPlay, playPk.personPlay) &&
                Objects.equals (filmPlay, playPk.filmPlay);
    }

    @Override
    public int hashCode() {
        return Objects.hash (personPlay, filmPlay);
}
 
    
}
