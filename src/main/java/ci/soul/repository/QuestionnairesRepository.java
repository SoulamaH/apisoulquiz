/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.soul.repository;

import ci.soul.entities.Questionnaires;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * repository (represente le package dao) : l'interface QuestionnairesRepository contiendra des méthodes propres 
 * au traitement du Questionnaire et elle herite de l'interface JpaRepository de Spring qui a des méthode déjà declarées
 * 
 * @author USER
 */
public interface QuestionnairesRepository extends JpaRepository<Questionnaires, Integer>{
    
}
