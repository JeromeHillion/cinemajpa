package fr.laerce.cinema.controller;


import fr.laerce.cinema.dao.FilmDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/** On indique à springboot qu'il s'agit d'une classe controller**/
@Controller
@RequestMapping(value = "film")
public class FilmController {

    @Autowired
    FilmDao filmDao;

    @GetMapping("/film_list")
    public String film_list(Model model){
        model.addAttribute("films", filmDao.findAll());
        return "film/film_list";
    }

    @GetMapping("/film_form")
    public String film_form(Model model){
        model.addAttribute("films", filmDao.findAll());
        return "film/film_form";
    }

}
