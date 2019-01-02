package fr.laerce.cinema.service;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "cinema.path")
@Validated
public class Path {
    private String image_path;
    private String person;

    public String getimage_path() {
        return image_path;
    }

    public void setimage_path(String image_path) {
        this.image_path = image_path;
    }

    public String getperson() {
        return person;
    }

    public void setperson(String person) {
        this.person = person;
    }
}
