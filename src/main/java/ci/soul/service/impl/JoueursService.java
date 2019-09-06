/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.soul.service.impl;

import ci.soul.entities.Joueurs;
import ci.soul.repository.JoueurRepository;
import ci.soul.service.IJoueursService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * JoueursService redefinir les methodes de l'interface IJoueursService
 *
 * @author USER
 */
@Service
public class JoueursService implements IJoueursService {

    // Injection par interface
    @Autowired
    private JoueurRepository joueurRepository;

    /**
     * enregistrement d'un objet
     *
     * @param joueur
     * @return
     */
    @Override
    public Joueurs create(Joueurs joueur) {
        return this.joueurRepository.save(joueur);
    }

     //Renvoie un element par l'id
    @Override
    public Joueurs readOne(Integer id) {
        return this.joueurRepository.getOne(id);
    }

     //modiffie un element grace a l'id
    @Override
    public Joueurs update(Joueurs joueurs) {
        return this.joueurRepository.save(joueurs);
    }

    //supprime un element par l'id
    @Override
    public void delete(Integer id) {
        this.joueurRepository.deleteById(id);
    }

    /**
     * renvoie la liste de tous les joueurs
     *
     * @return
     */
    @Override
    public List<Joueurs> readAll() {
        return this.joueurRepository.findAll();
    }

     //retourne la liste des joueurs par numero
    @Override
    public Joueurs readOneJoueursByNumero(String numero) {
        List<Joueurs> listJoueurs = joueurRepository.findJoueursByNumero(numero);

        // on retourne le premier joueurs si la liste
        // n'est pas null
        if (!listJoueurs.isEmpty()){
            return listJoueurs.get(0);
        }
        return null ;
    }

    @Override
    public void deletAll() {
         this.joueurRepository.deleteAll();
    }

}
