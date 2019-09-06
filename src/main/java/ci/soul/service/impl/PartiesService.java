/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.soul.service.impl;

import ci.soul.entities.Parties;
import ci.soul.repository.PartiesRepository;
import ci.soul.service.IPartiesService;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PartiesService redefinir les methodes de l'interface IPartiesService
 *
 * @author USER
 */
@Service
public class PartiesService implements IPartiesService {

    // variable 
    private int meilleurScore;

    // injection par interface 
    @Autowired
    private PartiesRepository partiesRepository;

    /**
     * enregistrement d'un element
     *
     * @param parties
     * @return
     */
    @Override
    public Parties create(Parties parties) {
        return this.partiesRepository.save(parties);
    }

    /**
     * retourne un element
     *
     * @param id
     * @return
     */
    @Override
    public Parties readOne(Integer id) {
        return this.partiesRepository.getOne(id);
    }

    /**
     * modiffie un element
     *
     * @param parties
     * @return
     */
    @Override
    public Parties update(Parties parties) {
        return this.partiesRepository.save(parties);
    }

    /**
     * supprime un element
     *
     * @param id
     */
    @Override
    public void delete(Integer id) {
        this.partiesRepository.deleteById(id);
    }

    /**
     * retoune la liste de tous les elments
     *
     * @return
     */
    @Override
    public List<Parties> readAll() {
        return this.partiesRepository.findAll();
    }

    /**
     * methode pour retourner le meilleurs score
     *
     * @return
     */
    @Override
    public Parties getFirstBestScore() {
        //initialisation
        meilleurScore = 0;

        // variables
        List<Parties> listParties = readAll();

        //objet
        Parties parties = null;

        //
        for (Parties parties1 : listParties) {

            //
            if (parties1.getScore() > meilleurScore) {
                parties = parties1;
                meilleurScore = parties1.getScore();
            }
        }
        return parties;
    }

    /**
     * methode pour retourner les meilleurs
     *
     * @return
     */
    @Override
    public List<Parties> getBestScore(String nomCategories, String niveauDifficultes) {

        meilleurScore = 0;
        Parties parties;

        List<Parties> listPartiesRetournee = new LinkedList<>();

        List<Parties> listParties = partiesRepository.findByCategoriesNameAndDifficultesNiveauDifficultes(nomCategories, niveauDifficultes).orElse(null);

        if (!listParties.isEmpty()){
            for (int i = 0; i < 5; i++) {

                meilleurScore = 0;
                parties = null;

                for (Parties party : listParties) {
                    if (party.getScore() >= meilleurScore) {
                        parties = party;
                        meilleurScore = party.getScore();
                    }
                }

                listPartiesRetournee.add(parties);
                listParties.remove(parties);
            }
            return listPartiesRetournee; // retourne la listes des parties
        }
        return null;
    }

    // suppression de tous les elements 
    @Override
    public void deletePartiesAll() {
        partiesRepository.deleteAll();
    }

}
