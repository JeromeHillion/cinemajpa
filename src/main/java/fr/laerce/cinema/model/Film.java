package fr.laerce.cinema.model;
import javax.persistence.*;
import java.util.Objects;

@Entity(name = "films")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "title", nullable = false, length = 60)
    private String titre;
    @Basic
    @Column(name ="rating", nullable = true)
    private String notation;
    @Basic
    @Column(name = "summary", nullable = true)
    private String resume;
    @Basic
    @Column(name="image_path",length = 120)
    private String affiche;
    @ManyToOne
    @JoinColumn(name="film_director")
    private Personne realisateur;

    public Personne getRealisateur(){
        return realisateur;
    }

    public void setRealisateur(Personne realisateur) {
        this.realisateur = realisateur;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getNotation() {
        return notation;
    }

    public void setNotation(String notation) {
        this.notation = notation;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getAffiche() {
        return affiche;
    }

    public void setAffiche(String affiche) {
        this.affiche = affiche;
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


