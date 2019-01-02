package fr.laerce.cinema.controller;


import fr.laerce.cinema.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/** On indique à springboot qu'il s'agit d'une classe controller**/
@Controller
public class PersonController {

    @Autowired
    PersonDao personDao;



  /*  @Autowired
    ImageManager imm;*/

    @GetMapping("/actor_list")
    public String actor_list(Model model) {
        /*On mappe la liste par ordre alphabétique pour la vue*/
        model.addAttribute("personnes", personDao.findAllByOrderByIdAsc());
        return "person/actor_list";
    }

   /* @GetMapping("/actor_detail/")
    public String detail(Model model) {
        model.addAttribute("person", personneDao.findAll());

    }*/


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
/*
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

*/
}




