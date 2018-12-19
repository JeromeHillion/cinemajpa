package fr.laerce.cinema.controller;


import fr.laerce.cinema.dao.PersonneDao;
import fr.laerce.cinema.model.Film;
import fr.laerce.cinema.model.Personne;
import fr.laerce.cinema.service.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;


/** On indique à springboot qu'il s'agit d'une classe controller**/
@Controller
@RequestMapping(value = "/person")
public class PersonneController {

    @Autowired
    PersonneDao personneDao;

    @Autowired
    Path path;

  /*  @Autowired
    ImageManager imm;*/

    @GetMapping("/actor_list")
    public String actor_list(Model model) {
        model.addAttribute("personnes", personneDao.findAll());
        return "person/actor_list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") long id, Model model) {
        /*model.addAttribute("personne", personneDao.findById(id).get());*/
        /** Avec gestion des erreurs**/
        Personne personne;
        personne = personneDao.findById(id).orElseThrow(() -> new IllegalArgumentException("Requète invalide"));
        return "person/detail";
    }

    /** Gestion de l'affichage de l'image**/
    @GetMapping("/photo/{nom}")
    public void photo(HttpServletRequest request, HttpServletResponse response, @PathVariable("nom") String nom) throws IOException{

        String filename = "C:\\Users\\CDI\\Documents\\images\\photos\\"+ nom + ".jpg";//  path.getAffiche() + id;

        // ============ UTILITAIRE POUR IMPORTER DES IMAGES A PARTIR D'UN FOLDER EXTERNE A L'APPLICATION ============ //
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



    @GetMapping("/mod/{id}")
    public String mod(@PathVariable("id") long id, Model model) {
        model.addAttribute("personne", personneDao.findById(id).get());
        return "person/form";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("personne", new Personne());
        return "person/form";
    }

/*    @PostMapping("/add")
    public String submit(@RequestParam("photo") MultipartFile file, @ModelAttribute Personne personne) {
        if (file.getContentType().equalsIgnoreCase("image/jpeg")) {
            try {
                imm.savePhoto(personne, file.getInputStream());
            } catch (IOException ioe) {
                System.out.println("Erreur lecture : " + ioe.getMessage());
            }
        }
        personneDao.save(personne);
        return "redirect:/person/list";
    }*/
}




