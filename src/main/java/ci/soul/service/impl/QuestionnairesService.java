/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.soul.service.impl;

import ci.soul.entities.Questionnaires;
import ci.soul.repository.QuestionnairesRepository;
import ci.soul.service.IQuestionnairesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * QuestionnairesService redefinir les methodes de l'interface
 * IQuestionnairesService
 *
 * @author USER
 */
@Service
public class QuestionnairesService implements IQuestionnairesService {

    // injection par interface
    @Autowired
    private QuestionnairesRepository questionnairesRepository;

    /**
     * enregistrement d'un element
     *
     * @param questionnaires
     * @return
     */
    @Override
    public Questionnaires create(Questionnaires questionnaires) {
        return this.questionnairesRepository.save(questionnaires);
    }

    /**
     * retourne un element
     *
     * @param id
     * @return
     */
    @Override
    public Questionnaires readOne(Integer id) {
        return this.questionnairesRepository.getOne(id);
    }

    /**
     * modiffie un element
     * 
     * @param questionnaires
     * @return 
     */
    @Override
    public Questionnaires update(Questionnaires questionnaires) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * supprime un element
     * 
     * @param id 
     */
    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * retourne la liste de tous les elmnets
     *
     * @return
     */
    @Override
    public List<Questionnaires> readAll() {
        return this.questionnairesRepository.findAll();
    }

}
