package fr.laerce.cinema.controller;
import fr.laerce.cinema.dao.FilmsTmdbDao;
import fr.laerce.cinema.service.TmdbImportsFiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/admin")
public class TmdbController {

    @Autowired
    private FilmsTmdbDao filmsTmdbDao;

    @GetMapping("/import")
    public String populate(Model model) {

        model.addAttribute("nom", "JeromeGide");

        TmdbImportsFiles tmdbImportsFiles = new TmdbImportsFiles(filmsTmdbDao);
        tmdbImportsFiles.ImportMoviesViaOnlineTmdbFile();

        //TODO: devra plus tard retourner une interface d'administration plutôt que l'index
        return "index";
    }
}
