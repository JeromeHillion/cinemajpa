package fr.laerce.cinema.model;
import javax.persistence.*;
import java.util.List;


@Entity(name = "persons")
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "surname", nullable = false, length = 60)
    private String nom;
    @Basic
    @Column(name = "givenname", nullable = true, length = 40)
    private String prenom;
    @Basic
    @Column(name = "birth_year", nullable = true)
    private Integer naissance;
    @Basic
    @Column(name = "image_path", nullable = true, length = 80)
    private String affiche;
    @OneToMany(mappedBy = "realisateur")
    private List<Film> films;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String surname) {
        this.nom = surname;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String givenname) {
        this.prenom = givenname;
    }

    public Integer getNaissance() {
        return naissance;
    }

    public void setNaissance(Integer birthYear) {
        this.naissance = birthYear;
    }

    public String getAffiche() {
        return affiche;
    }

    public void setAffiche(String imagePath) {
        this.affiche = imagePath;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Personne persons = (Personne) o;

        if (id != persons.id) return false;
        if (nom != null ? !nom.equals(persons.nom) : persons.nom != null) return false;
        if (prenom != null ? !prenom.equals(persons.prenom) : persons.prenom != null) return false;
        if (naissance != null ? !naissance.equals(persons.naissance) : persons.naissance != null) return false;
        if (affiche != null ? !affiche.equals(persons.affiche) : persons.affiche != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (naissance != null ? naissance.hashCode() : 0);
        result = 31 * result + (affiche != null ? affiche.hashCode() : 0);
        return result;
    }
}