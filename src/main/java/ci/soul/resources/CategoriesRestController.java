/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.soul.resources;

import ci.soul.entities.Categories;
import ci.soul.entities.Difficultes;
import ci.soul.service.ICategoriesService;
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
@RequestMapping("/api/categories")
public class CategoriesRestController {
    
    // injection par interface
    @Autowired
    private ICategoriesService iCategoriesService;
    
     // enregistrement de la difficultes
    @PostMapping
    public Categories save(@RequestBody Categories categories){
        return iCategoriesService.create(categories);
    }
    
     // retourne tous les elements
    @GetMapping("/listecategories")
    public List<Categories> getAllCategories(){
        return iCategoriesService.readAll();
    }
    
    // suppression de tous les elements 
    @DeleteMapping("/deleteallcategories")
    public void delteteAllCategories(){
        iCategoriesService.deleteAllCategories();
    }
    
}
