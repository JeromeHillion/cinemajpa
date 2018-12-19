package fr.laerce.cinema;

import fr.laerce.cinema.service.Path;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;



@SpringBootApplication
@Configuration
@EnableConfigurationProperties(Path.class)/** fait le liens entre l' application.properties et les propriété créer dans la classe Path**/
public class CinemaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaApplication.class, args);
    }


    }



