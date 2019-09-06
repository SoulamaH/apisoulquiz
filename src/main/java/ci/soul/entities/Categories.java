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
 * class Categories contenant les informations de la Categorie = langage
 * 
 * @author USER
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Categories implements Serializable{
    
    // propriétés de la classe
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // nom des langages
    private String name;
    
    // constructeur sans id
    public Categories(String name) {
        this.name = name;
    }
    
}
