package fr.laerce.cinema.controller;


import fr.laerce.cinema.dao.PersonneDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/** On indique à springboot qu'il s'agit d'une classe controller**/
@Controller
public class MainController {

    /** On utilise cet méthode avec autowired et component d    ns le servlet PersonneDao**/
    @Autowired
    PersonneDao personneDao;

    /** On mappe notre servlet pour la rediriger vers le template index.html**/
    @GetMapping("/")
    public String main (Model model) {

        /** On ajoute l'objet model la clef "annonce" et "sur le site de cineman"**/
        model.addAttribute("annonce", "sur le site du Cineman");
        model.addAttribute("films", personneDao.getFilms());
        return "index";
    }

    /**On mappe notre servlet pour la rediriger vers le template film.html**/
    @GetMapping("/film")
    public String film (Model model ){
        /** On ajoute a l'objet  personnedao pour la vue**/
        model.addAttribute("films", personneDao.getFilms());
        return "film";
    }

    /**On mappe notre servlet pour la rediriger vers le template rechercher.html**/
    @GetMapping("/rechercher")
    public String rechercher(Model model){
        return "rechercher";
    }
}
