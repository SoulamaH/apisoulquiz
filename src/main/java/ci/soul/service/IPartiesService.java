/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.soul.service;

import ci.soul.entities.Parties;
import java.util.List;

/**
 *
 * @author USER
 */
public interface IPartiesService {

    // methode pour creer une Parties
    public Parties create(Parties parties);

    // methode pour retourner une Parties
    public Parties readOne(Integer id);

    // methode pour modiffier une Parties
    public Parties update(Parties parties);

    // methode pour supprimer une Parties
    public void delete(Integer id);

    // methode pour retourner la liste de Parties
    public List<Parties> readAll();
    
    // retourner le meilleur score
    public Parties getFirstBestScore();
    
    // retourner les meilleurs score
    public List<Parties> getBestScore(String nomCategories, String niveauDifficultes);
    
    // supprimer tous les elements
    public void deletePartiesAll();
}
