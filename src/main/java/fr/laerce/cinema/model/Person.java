package fr.laerce.cinema.model;
import java.time.LocalDate;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "surname", nullable = false, length = 200)
    private String name;
  @Basic
    @Column(name = "givenname", nullable = false, length = 200)
    private String givenname;

    @Basic
    @Column(name = "birthday", nullable = true)
    private LocalDate birthday;
    @Basic
    @Column(name = "image_path", nullable = true, length = 80)
    private String profile_path;
   /* @OneToMany(mappedBy = "director")
    private Set<Film> directedFilms;*/
    /*@OneToMany(mappedBy = "know_for_department", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Play> roles;*/



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String surname) {
        this.name = name;
    }



    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthYear) {
        this.birthday = birthYear;
    }

    public String getProfile_path() {
        return profile_path;
    }

    public void setProfile_path(String imagePath) {
        this.profile_path = profile_path;
    }

    /*public Set<Film> getDirectedFilms() {
        return directedFilms;
    }

    public void setDirectedFilms(Set<Film> films) {
        this.directedFilms = films;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person persons = (Person) o;

        if (id != persons.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", prénom et nom='" + name + '\'' +
                ", naissance=" + birthday +
                ", photos='" + profile_path + '\'' +
                '}';
    }
}