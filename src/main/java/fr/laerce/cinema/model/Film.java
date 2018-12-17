package fr.laerce.cinema.model;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="films")
public class Film  {
    private Long id;
    private String titre;
    private Double notation;
    private String affiche;
    private String resume;
    private Personne realisateur;
   /* private List<Role> roles;*/





    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 60)
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
    @Basic
    @Column(name ="rating", nullable = true)
    public Double getNotation() {
        return notation;
    }

    public void setNotation(Double notation) {
        this.notation = notation;
    }
    @Basic
    @Column(name = "summary", nullable = true)
    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }
    @Basic
    @Column(name="image_path",length = 120)
    public String getAffiche() {
        return affiche;
    }
    public void setAffiche(String affiche) {
        this.affiche = affiche;
    }
    @ManyToOne
    @JoinColumn(name="film_director")
    public Personne getRealisateur() {
        return realisateur;
    }

    public void setRealisateur (Personne realisateur)  {
        this.realisateur = realisateur;
    }




 /*   public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }*/


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(id, film.id) &&
                Objects.equals(titre, film.titre) &&
                Objects.equals(notation, film.notation) &&
                Objects.equals(affiche, film.affiche) &&
                Objects.equals(resume, film.resume) &&
                Objects.equals(realisateur, film.realisateur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titre, notation, affiche, resume, realisateur);
    }
    /*   return Objects.hash(getTitre(), getNotation(), getResume());*/

    }


