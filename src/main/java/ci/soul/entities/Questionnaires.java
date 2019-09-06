/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.soul.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * class Questionnaires contenant les informations du Questionnaires
 * 
 * @author USER
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Questionnaires implements Serializable{
 
    // propriétés de la classe
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String questions;
    private String option1;
    private String option2;
    private String option3;
    private Integer reponses;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    private Categories categories;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    private Difficultes difficultes;
    
    // constructeus sans id
    public Questionnaires(String questions, String option1, String option2, String option3, Integer reponses, Categories categories, Difficultes difficultes) {
        this.questions = questions;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.reponses = reponses;
        this.categories = categories;
        this.difficultes = difficultes;
    }
    
}
