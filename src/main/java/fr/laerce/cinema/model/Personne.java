package fr.laerce.cinema.model;
import java.time.LocalDate;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "persons")
public class Personne {
    private long id;
    private String surname;
    private String givenname;
    private LocalDate naissance;
    private String image_path;
    private List<Film> listeFilms;
    private List<Role> posts;

    public Personne() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "person")
    public List<Role> getPosts() {
        return posts;
    }

    public void setPosts(List<Role> posts) {
        this.posts = posts;
    }
    @Basic
    @Column(name = "surname", nullable = false, length = 60)
    public String getsurname() {
        return surname;
    }

    public void setsurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "givenname", nullable = true, length = 40)
    public String getgivenname() {
        return givenname;
    }

    public void setgivenname(String givenname) {
        this.givenname = givenname;
    }

    @Basic
    @Column(name = "birthday", nullable = true)
    public LocalDate getNaissance() {
        return naissance;
    }

    public void setNaissance(LocalDate birthYear) {
        this.naissance = birthYear;
    }

    @Basic
    @Column(name = "image_path", nullable = true, length = 80)
    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String imagePath) {
        this.image_path = imagePath;
    }


    @OneToMany
    public List<Film> getListeFilms() { return listeFilms; }
    public void setListeFilms(List<Film> listeFilms) { this.listeFilms = listeFilms; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Personne personne = (Personne) o;

        if (id != personne.id) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        return result;
    }

}