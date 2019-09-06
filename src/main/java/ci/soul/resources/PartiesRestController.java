/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.soul.resources;

import ci.soul.entities.Categories;
import ci.soul.entities.Difficultes;
import ci.soul.entities.Joueurs;
import ci.soul.entities.Parties;
import ci.soul.service.ICategoriesService;
import ci.soul.service.IJoueursService;
import ci.soul.service.IPartiesService;
import ci.soul.service.impl.DifficultesService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author USER
 */
@RestController
@CrossOrigin
@RequestMapping("/api/parties")
public class PartiesRestController {
    
    // injection par interface
    @Autowired
    private IPartiesService iPartiesService;
    @Autowired
    private IJoueursService iJoueursService;
    @Autowired
    private ICategoriesService iCategoriesService;
    @Autowired
    private DifficultesService iDifficultesService;

    
   //objects
    private Joueurs joueurs;
    private Categories categories;
    private Difficultes difficultes;

    private final Logger logger = LoggerFactory.getLogger(PartiesRestController.class);
    
    // enregistrer une partie
    //mais on retourne la liste des meilleurs score 
    //pour un soucis de chargements dans le getBestScore
    @PostMapping
    public ResponseEntity save(@RequestBody Parties parties){
        List<Parties>partiesList = null;
        // affectation
        logger.info(" **** PartiesRestController save partie ***** : " + parties);
        joueurs = iJoueursService.readOneJoueursByNumero(parties.getJoueurs().getNumero());
        logger.info(" **** PartiesRestController save ***** : " + joueurs);
        difficultes = iDifficultesService.readOneByDifficultesNiveauDifficultes(parties.getDifficultes().getNiveauDifficultes());
        logger.info(" **** PartiesRestController save*** " + difficultes);
        categories =  iCategoriesService.readOneCategoriesByName(parties.getCategories().getName());
        logger.info(" **** PartiesRestController save *** " + categories);
       
        // condition
        if(joueurs != null && difficultes !=  null && categories != null){
            logger.info(" **** PartiesRestController save if ***** : " + joueurs);
            parties.setJoueurs(joueurs);
            parties.setDifficultes(difficultes);
            parties.setCategories(categories);
            logger.info(" **** PartiesRestController save fin If ***** : " + parties);
        }
        logger.info(" **** PartiesRestController save return ***** : " + iPartiesService.create(parties));
        // enregistrement de la partie avec ses infos
         iPartiesService.create(parties);
         
         partiesList = iPartiesService.getBestScore(parties.getCategories().getName(), parties.getDifficultes().getNiveauDifficultes());

         if (!partiesList.isEmpty()){
             return new ResponseEntity(partiesList, HttpStatus.ACCEPTED);
         }
         return new ResponseEntity(" Echec du chargement de la liste",HttpStatus.NOT_FOUND);
    }
    
    // retourne le meilleur score
    @GetMapping("/bestscore")
    public Parties getFirstBestScore(){
         return iPartiesService.getFirstBestScore();
    }
    
    // retourne les meilleur score
    @PostMapping("/lesbestscore")
    public List<Parties> getBestScore(@RequestParam(value ="nomCategories") String nomCategories, @RequestParam(value ="niveauDifficultes")String niveauDifficultes){
         return iPartiesService.getBestScore(nomCategories, niveauDifficultes);
    }
    
    // retourne la liste de tous les scores
    @GetMapping("/listdesparties")
    public List<Parties> getAllParties(){
        return iPartiesService.readAll();
    }
    
    // suppression de tous les elements
    @DeleteMapping("/deleteallparties")
    public void deleteAllParies(){
        iPartiesService.deletePartiesAll();
    }
}
