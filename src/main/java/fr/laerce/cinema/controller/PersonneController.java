package fr.laerce.cinema.controller;


import fr.laerce.cinema.dao.PersonneDao;
import fr.laerce.cinema.model.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.IIOException;


/** On indique à springboot qu'il s'agit d'une classe controller**/
@Controller
@RequestMapping("/person")
public class PersonneController {

    /**
     * On utilise cet méthode avec autowired et component d    ns le servlet PersonneDao
     **/
    @Autowired
    PersonneDao personneDao;

    /**
     * On mappe notre servlet pour la rediriger vers le template index.html
     **/
    @GetMapping("/list")
    public String list(Model model) {

        /** On ajoute l'objet model la clef "annonce" et "sur le site de cineman"**/
        model.addAttribute("annonce", "sur le site du Cineman");
        model.addAttribute("personnes", personneDao.getAll());
        return "person/list";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") String id, Model model){
        long idPersonne = Long.parseLong(id);
        model.addAttribute("personne", personneDao.getById(idPersonne));
        return "/person/detail";
    }

    @GetMapping("/form")
    public String formPersonne( Model model){
        model.addAttribute("personne", new Personne());
        return "person/form";
    }

    @GetMapping("/add")
    public String add(@ModelAttribute Personne personne){
        personneDao.save(personne);
        return "redirect:/person/list";
    }

/*    @PostMapping("/add")
    public String submit(@RequestMapping("photo")MultipartFile file, @ModelAttribute Personne persone){
        System.out.println(file.getOriginalFilename()+"------"+file.getContentType()+"-----"+file.getSize());
        if (file.getContentType().equalsIgnoreCase("image/jpeg")){
            try{
                imm.savePhoto(persone, file.getInputStream());
            }
            catch (IIOException ioe){
                System.out.println("Erreur lecture : " +ioe.getMessage());
            }
        }
        personneDao.save(persone);
        return "redirect:/person/list"
    }*/

}

