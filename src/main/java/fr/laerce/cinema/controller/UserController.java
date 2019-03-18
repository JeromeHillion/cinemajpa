package fr.laerce.cinema.controller;

import fr.laerce.cinema.model.Film;
import fr.laerce.cinema.model.User;
import org.springframework.ui.Model;
import fr.laerce.cinema.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserManager userManager;

    @GetMapping("/list")
    public String list(Model model) {
        Iterable<User> users = userManager.getAll();
        model.addAttribute("user", users);
        return "user/user_list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("givename", "Ajout d'un utilisateur");
        model.addAttribute("user", new User());
        return "index";
    }

/*    @GetMapping("/mod/{id}")
    public String mod(@PathVariable("id") long id, Model model) {
        User user = UserManager.getById(id);
        model.addAttribute("surname", user.getSurname());
        model.addAttribute("givenname", user.getGivenname());
        model.addAttribute("password", user.getPassword());
        model.addAttribute("user", user);



    }*/
@PostMapping("add")
    public String submit(@ModelAttribute User user){
    userManager.saveUser(user);
    return "redirect:list";
}

}