/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.soul.resources;

import ci.soul.entities.Difficultes;
import ci.soul.service.IDifficultesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USER
 */
@RestController
@CrossOrigin
@RequestMapping("/api/difficultes")
public class DifficultesRestController {
 
    // injection par interface
    @Autowired
    private IDifficultesService iDifficultesService;
    
    // enregistrement de la difficultes
    @PostMapping
    public Difficultes save(@RequestBody Difficultes difficultes){
        return iDifficultesService.create(difficultes);
    }
    
    // retourne tous les elements
    @GetMapping("/listedifficultes")
    public List<Difficultes> getAllDifficultes(){
        return iDifficultesService.readAll();
    }
    
    // suppression de tous les elements
    @DeleteMapping("/deletealldifficultes")
    public void deleteAllDificultes(){
        iDifficultesService.deleteAllDifficultes();
    }
}
