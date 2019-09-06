/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.soul.service;

import ci.soul.entities.Categories;
import java.util.List;

/**
 * Traitement metier propre a la categories 
 * Declaration des méthodes à implementer
 * pour les classes qui en hériteront
 * 
 * @author USER
 */
public interface ICategoriesService {
    
    // methode pour creer une Categories = langage
    public Categories create(Categories categories);
    // methode pour retourner une Categories
    public Categories readOne (Integer id);
    // methode pour modiffier une Categories
    public Categories update(Categories categories);
    // methode pour supprimer une Categories
    public void delete(Integer id);
    // methode pour retourner la liste de toutes les Categories
    public List<Categories> readAll();  
    
    // retourne la categorie par langage = categorie
    public Categories readOneCategoriesByName(String name);
    // supprimer tous les elements
    public void deleteAllCategories();
}
