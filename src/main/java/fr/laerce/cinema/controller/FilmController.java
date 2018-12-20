package fr.laerce.cinema.controller;


import fr.laerce.cinema.dao.FilmDao;
import fr.laerce.cinema.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

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

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") long id, Model model) {
        /*model.addAttribute("personne", filmDao.findById(id).get());*/
        /** Avec gestion des erreurs**/
        Film film;
        film = filmDao.findById(id).orElseThrow(() -> new IllegalArgumentException("Requète invalide"));
        return "film/detail";
    }

    /**Gestion de l'afichage des affiches de film**/
    @GetMapping("/poster/{titre}")
    public void affiche(HttpServletRequest request, HttpServletResponse response, @PathVariable("titre") String titre) throws IOException{
        String filename = "C:\\Users\\CDI\\Documents\\images\\poster\\"+titre;

        /**UTILITAIRE POUR IMPORTER DES IMAGES A PARTIR D'UN FOLDER EXTERNE A L'APPLICATION**/
        String mime = request.getServletContext().getMimeType(filename);
        if (mime == null) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
        response.setContentType(mime);
        File file = new File(filename);
        response.setContentLength((int) file.length());
        FileInputStream in = new FileInputStream(file);
        OutputStream out = response.getOutputStream();
        byte[] buf = new byte[1024];
        int count = 0;
        while ((count = in.read(buf)) >= 0) {
            out.write(buf, 0, count);
        }
        out.close();
        in.close();
    }


    @GetMapping("/film_form")
    public String film_form(Model model){
        model.addAttribute("films", filmDao.findAll());
        return "film/film_form";
    }

}
