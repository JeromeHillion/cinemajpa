package fr.laerce.cinema.controller;

import fr.laerce.cinema.dao.FilmDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/** On indique à springboot qu'il s'agit d'une classe controller**/
@Controller
public class MainController {

    @Autowired
    FilmDao filmDao;
    
    /* Path path;*/

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("films", filmDao.findAll());
        return "index";
    }

/*
    @GetMapping("film/film_detail/{id}")
    public String detail(@PathVariable("id") long id, Model model) {
        */
/*model.addAttribute("personne", filmDao.findById(id).get());*//*

        */
/** Avec gestion des erreurs**//*

        Film film;
        film = filmDao.findById(id).orElseThrow(() -> new IllegalArgumentException("Requète invalide"));
        return "film/film_detail";
    }
*/

//    /**Gestion de l'afichage des affiches de film**/
//    @GetMapping("/poster/{affiche}")
//    public void  affiche(HttpServletRequest request, HttpServletResponse response, @PathVariable("affiche") String affiche) throws IOException{
//        String filename = "C:\\Users\\Gideon\\Pictures\\affiches\\"+affiche+".jpg";
//
//        /**UTILITAIRE POUR IMPORTER DES IMAGES A PARTIR D'UN FOLDER EXTERNE A L'APPLICATION**/
//        String mime = request.getServletContext().getMimeType(filename);
//        if (mime == null) {
//            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//            return;
//        }
//        response.setContentType(mime);
//        File file = new File(filename);
//        response.setContentLength((int) file.length());
//        FileInputStream in = new FileInputStream(file);
//        OutputStream out = response.getOutputStream();
//        byte[] buf = new byte[1024];
//        int count = 0;
//        while ((count = in.read(buf)) >= 0) {
//            out.write(buf, 0, count);
//        }
//        out.close();
//        in.close();
//    }
}
