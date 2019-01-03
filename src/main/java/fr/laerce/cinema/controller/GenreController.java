package fr.laerce.cinema.controller;

import fr.laerce.cinema.dao.GenreDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GenreController {
    GenreDao genreDao;

    @GetMapping("/film_detail")
    public String role_list(Model model){
        model.addAttribute("genres" , genreDao.findAllByOrderByIdAsc());
        return ("film/film_detail");
    }
}
