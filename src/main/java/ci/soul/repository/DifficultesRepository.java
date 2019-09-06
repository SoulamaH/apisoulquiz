/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.soul.repository;

import ci.soul.entities.Difficultes;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * repository (represente le package dao) : l'interface DifficultesRepository contiendra des méthodes propres 
 * au traitement du Difficultes et elle herite de l'interface JpaRepository de Spring qui a des méthode déjà declarées
 * 
 * @author USER
 */
public interface DifficultesRepository extends JpaRepository<Difficultes, Integer>{
    
    // recherche par niveau de difficultes
    public Optional<List<Difficultes>> findByNiveauDifficultes(String niveauDifficultes);
}
