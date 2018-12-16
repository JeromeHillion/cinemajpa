package fr.laerce.cinema.model;

import javax.persistence.*;

@Entity
public class Personne {
    private long id;
    private String nom;
    private String prenom;
    private Integer naissance;
    private String photoPath;

    public Personne(long id, String nom, String prenom, Integer naissance, String photoPath) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.naissance = naissance;
        this.photoPath = photoPath;
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

    @Basic
    @Column(name = "nom", nullable = false, length = 60)
    public String getnom() {
        return nom;
    }

    public void setnom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "prenom", nullable = true, length = 40)
    public String getprenom() {
        return prenom;
    }

    public void setprenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "birth_year", nullable = true)
    public Integer getnaissance() {
        return naissance;
    }

    public void setnaissance(Integer naissance) {
        this.naissance = naissance;
    }

    @Basic
    @Column(name = "image_path", nullable = true, length = 80)
    public String getphotoPath() {
        return photoPath;
    }

    public void setphotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Personne personne = (Personne) o;

        if (id != personne.id) return false;
        if (nom != null ? !nom.equals(personne.nom) : personne.nom != null) return false;
        if (prenom != null ? !prenom.equals(personne.prenom) : personne.prenom != null) return false;
        if (naissance != null ? !naissance.equals(personne.naissance) : personne.naissance != null) return false;
        if (photoPath != null ? !photoPath.equals(personne.photoPath) : personne.photoPath != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (naissance != null ? naissance.hashCode() : 0);
        result = 31 * result + (photoPath != null ? photoPath.hashCode() : 0);
        return result;
    }
}
