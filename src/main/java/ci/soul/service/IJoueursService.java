/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.soul.service;

import ci.soul.entities.Joueurs;
import java.util.List;

/**
 * Traitement metier propre au Joueurs Declaration des méthodes à implementer
 * pour les classes qui en hériteront
 *
 * @author USER
 */
public interface IJoueursService {

    // methode pour creer un joueur
    public Joueurs create(Joueurs joueur);

    // methode pour retourner un joueur
    public Joueurs readOne(Integer id);

    // methode pour modiffier un joueur
    public Joueurs update(Joueurs joueurs);

    // methode pour supprimer un joueur
    public void delete(Integer id);
    
    // methode pour supprimer tous les joueurs
    public void deletAll();

    // methode pour retourner la liste de tous les joueurs
    public List<Joueurs> readAll();
    
    // retourne un joueur par son numero 
    public Joueurs readOneJoueursByNumero(String numero);

}
