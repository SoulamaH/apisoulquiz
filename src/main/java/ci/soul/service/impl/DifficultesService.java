/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.soul.service.impl;

import ci.soul.entities.Difficultes;
import ci.soul.repository.DifficultesRepository;
import ci.soul.service.IDifficultesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DifficultesService redefinir les methodes de l'interface IDifficultesService
 *
 * @author USER
 */
@Service
public class DifficultesService implements IDifficultesService {

    // injection par interface
    @Autowired
    private DifficultesRepository difficultesRepository;

    /**
     * enregistrement d'un element
     *
     * @param difficultes
     * @return
     */
    @Override
    public Difficultes create(Difficultes difficultes) {
        return this.difficultesRepository.save(difficultes);
    }

    /**
     * retourne un element
     *
     * @param id
     * @return
     */
    @Override
    public Difficultes readOne(Integer id) {
        return this.difficultesRepository.getOne(id);
    }

    /**
     * moddifie un element
     *
     * @param difficultes
     * @return
     */
    @Override
    public Difficultes update(Difficultes difficultes) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      return null;
    }

    /**
     * supprime un element par l'id
     *
     * @param id
     */
    @Override
    public void delete(Integer id) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * retourne la liste de tous les elements
     *
     * @return
     */
    @Override
    public List<Difficultes> readAll() {
        return this.difficultesRepository.findAll();
    }

    // retourne un element par niveau de ficulte
    @Override
    public Difficultes readOneByDifficultesNiveauDifficultes(String niveauDifficultes) {
        // "findByNiveauDifficultes(niveauDifficultes).orElse(null)" si l'objet existe on le retourne sinon on retourne "null"
        List<Difficultes> listDifficultes = difficultesRepository.findByNiveauDifficultes(niveauDifficultes).orElse(null);

        // si la liste est differente de null on retourne le prmier element
        if (!listDifficultes.isEmpty()){
            return listDifficultes.get(0);
        }
        return null;
    }

    // suppression de tous les elements
    @Override
    public void deleteAllDifficultes() {
            difficultesRepository.deleteAll();
    }

}
