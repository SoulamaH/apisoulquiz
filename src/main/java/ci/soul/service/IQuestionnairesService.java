/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.soul.service;

import ci.soul.entities.Questionnaires;
import java.util.List;

/**
 * Traitement metier propre au Questionnaire 
 * Declaration des méthodes à implementer
 * pour les classes qui en hériteront
 * 
 * @author USER
 */
public interface IQuestionnairesService {
    
     // methode pour creer un Questionnaires
    public Questionnaires create(Questionnaires questionnaires);
    // methode pour retourner un Questionnaires
    public Questionnaires readOne (Integer id);
    // methode pour modiffier un Questionnaires
    public Questionnaires update(Questionnaires questionnaires);
    // methode pour supprimer un Questionnaires
    public void delete(Integer id);
    // methode pour retourner la liste de tout le Questionnaires
    public List<Questionnaires> readAll();
}
