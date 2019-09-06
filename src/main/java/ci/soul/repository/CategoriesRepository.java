/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.soul.repository;

import ci.soul.entities.Categories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * repository (represente le package dao) : l'interface CategoriesRepository contiendra des méthodes propres 
 * au traitement de la Categories et elle herite de l'interface JpaRepository de Spring qui a des méthode déjà declarées
 * 
 * @author USER
 */
public interface CategoriesRepository extends JpaRepository<Categories, Integer>{
  
    // recherche par nom de langage = categories
    public Optional<List<Categories>> findByName(String name);
}
