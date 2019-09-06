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
 * class Parties contenant les informations de la Parties
 * 
 * @author USER
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Parties implements Serializable {
    
    // Propriétés de la classe
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY pour faire l'auto incremente
    private Integer id;
    
    private int score;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    private Joueurs joueurs;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    private Categories categories;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    private Difficultes difficultes;
    
    // constructeurs sans id
    public Parties(Joueurs joueurs, Categories categories, Difficultes difficultes) {
        this.joueurs = joueurs;
        this.categories = categories;
        this.difficultes = difficultes;
    }
}
