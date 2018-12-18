package fr.laerce.cinema.controller;


import fr.laerce.cinema.dao.PersonneDao;
import fr.laerce.cinema.model.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/** On indique à springboot qu'il s'agit d'une classe controller**/
@Controller
@RequestMapping(value = "/person")
public class PersonneController {

    @Autowired
    PersonneDao personneDao;

  /*  @Autowired
    ImageManager imm;*/

    @GetMapping("/actor_list")
    public String actor_list(Model model) {
        model.addAttribute("personnes", personneDao.findAll());
        return "person/actor_list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") long id, Model model) {
        model.addAttribute("personne", personneDao.findById(id).get());
        return "person/detail";
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




