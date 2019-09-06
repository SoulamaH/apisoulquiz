/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.soul.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * class Joueur contenant les informations du joueur
 * 
 * @author USER
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Joueurs implements Serializable{
    
    // propriétés de la classe
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String prenom;
    private String numero;
    private String email;
    private String password;

    
    //constructeurs sans id
    public Joueurs(String nom, String prenom, String numero, String email, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.email = email;
        this.password = password;
    }
    
}
