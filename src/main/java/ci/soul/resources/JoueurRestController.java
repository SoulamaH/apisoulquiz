/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.soul.resources;

import ci.soul.entities.Joueurs;
import ci.soul.service.IJoueursService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.springframework.http.ResponseEntity.ok;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USER
 */
@RestController
@CrossOrigin
@RequestMapping("/api/joueurs")
public class JoueurRestController {

    // objet
    private Joueurs joueurs;
    private final Logger logger = LoggerFactory.getLogger(JoueurRestController.class);
    // injection interface (service)
    @Autowired
    private IJoueursService iJoueursService;

    
    // methode de cretion d'un joueur
    @PostMapping
    public Joueurs save(@RequestBody Joueurs joueurs) {
        return iJoueursService.create(joueurs);
    }

    // methode pour la connexion dun joueur 
    @PostMapping("/login")
    public ResponseEntity login(@RequestParam("numero") String numero, @RequestParam("password") String password) {
        
        // recuperation du numero et affetation a la variable
        joueurs = iJoueursService.readOneJoueursByNumero(numero);

        // si le numero existe on verifie le password
        // sinon on retourne le message d'erreur "echec connexion"
        if (joueurs != null) {
            // si password est verifié on retourne "connexion reussie"
            if (joueurs.getPassword().equals(password)) {
                //return ok("connexion reussie");  
                return new ResponseEntity(joueurs,HttpStatus.ACCEPTED);
            }
        }
        //return new ResponseEntity("echec connexion",HttpStatus.NOT_ACCEPTABLE);
        return null;
    }
    
    // methode pour retourner tous les enregistrements
    @GetMapping
    public List<Joueurs> getAllJoueurs(){
        return iJoueursService.readAll();
    }

     // supprimer un enregistrement
    @DeleteMapping("/deleteonejoueurs")
    public void deleteOneJoueurs(Integer id){
        iJoueursService.delete(id);
    }
    
    // supprimer tous les enregistrements
    @DeleteMapping("/deletealljoueurs")
    public void deleletAllJoueurs(){
        iJoueursService.deletAll();
    }
}
