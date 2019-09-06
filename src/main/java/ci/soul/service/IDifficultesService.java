/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.soul.service;

import ci.soul.entities.Difficultes;
import java.util.List;

/**
 * Traitement metier propre a la Difficultes 
 * Declaration des méthodes à implementer
 * pour les classes qui en hériteront
 * 
 * @author USER
 */
public interface IDifficultesService {
    
     // methode pour creer une Difficultes
    public Difficultes create(Difficultes difficultes);
    // methode pour retourner une Difficultes
    public Difficultes readOne (Integer id);
    // methode pour modiffier une Difficultes
    public Difficultes update(Difficultes difficultes);
    // methode pour supprimer une Difficultes
    public void delete(Integer id);
    // methode pour retourner la liste de toute la Difficultes
    public List<Difficultes> readAll();
    //
    public Difficultes readOneByDifficultesNiveauDifficultes(String niveauDifficultes);
    // supprimer tous les element
    public void deleteAllDifficultes();
}
