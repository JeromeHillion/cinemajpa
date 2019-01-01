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
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


/** On indique à springboot qu'il s'agit d'une classe controller**/
@Controller
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

    @GetMapping("/actor_detail/{id}")
    public String detail(@PathVariable("id") long id, Model model) {
        /*model.addAttribute("personne", personneDao.findById(id).get());*/
        /** Avec gestion des erreurs**/
        Personne personne;
        personne = personneDao.findById(id).orElseThrow(() -> new IllegalArgumentException("Requète invalide"));
        model.addAttribute("personne", personne);
        return "person/actor_detail";
    }

    /** Gestion de l'affichage de l'image**/
   
//    @Value( "${url}" )
//    private String url;
//    //deuxieme methode pour affichezr  image
//    @GetMapping("/affiche/{id}")
//    public ResponseEntity<byte[]> getImageAsResponseEntity (HttpServletRequest request, HttpServletResponse response, @PathVariable("id") String id) {
//        try {
//            HttpHeaders headers = new HttpHeaders ();
//            String filename=url+id;
//            File i = new File (filename);
//            FileInputStream in = new FileInputStream(i);
//            byte[] media = IOUtils.toByteArray (in);
//            headers.setCacheControl (CacheControl.noCache ().getHeaderValue ());
//
//            ResponseEntity<byte[]> responseEntity = new ResponseEntity<> (media, headers, HttpStatus.OK);
//            return responseEntity;
//        } catch (IOException e) {
//            e.printStackTrace ();
//        }
//       return null;
// }
 //on copie/colle la methode pour le portrait des acteur
//    @Value( "${url2}" )
    private String url2;
    //que l'on mappe sur image/id id etant le nom brut de l'image
    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getImageAsResponseEntity2 (HttpServletRequest request, HttpServletResponse response, @PathVariable("id") String id) {
        try {
            HttpHeaders headers = new HttpHeaders ();
            String filename=url2+id;
            File i = new File (filename);
            FileInputStream in = new FileInputStream(i);
            byte[] media = IOUtils.toByteArray (in);
            headers.setCacheControl (CacheControl.noCache().getHeaderValue());

            ResponseEntity<byte[]> responseEntity = new ResponseEntity<> (media, headers, HttpStatus.OK);
            return responseEntity;
        } catch (IOException e) {
            e.printStackTrace ();
        }
        return null;
    }
    @GetMapping("/acteur/{id}")
    //on recupere id grace à pathvariable
    public String acteur(Model m, @PathVariable("id") String id){
        //on envoie a acteur la personne concernée grace a la methode getbyaf et id qui est le nom de l'image
        m.addAttribute ("actor", personneDao.findAllByImage_path (id));
        return"acteur";}
}





