/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.soul.repository;

import ci.soul.entities.Joueurs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * repository (represente le package dao) : l'interface JoueurRepository contiendra des méthodes propres 
 * au traitement du joueur et elle herite de l'interface JpaRepository de Spring qui a des méthode déjà declarées
 *
 * @author USER
 */
public interface JoueurRepository extends JpaRepository<Joueurs, Integer>{
    
    // recuperer le joueur par numero
    public List<Joueurs> findJoueursByNumero(String numero);
}
