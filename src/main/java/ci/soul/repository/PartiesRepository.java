/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.soul.repository;

import ci.soul.entities.Parties;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * repository (represente le package dao) : l'interface PartiesRepository contiendra des méthodes propres 
 * au traitement de la Parties et elle herite de l'interface JpaRepository de Spring qui a des méthode déjà declarées
 *
 * @author USER
 */
public interface PartiesRepository extends JpaRepository<Parties, Integer>{

    // retourne le la categorire et la difficulte
    public Optional<List<Parties>> findByCategoriesNameAndDifficultesNiveauDifficultes(String nomCategories, String niveauDifficultes);
 
}
