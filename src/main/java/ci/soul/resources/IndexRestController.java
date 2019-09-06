/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.soul.resources;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * classe controller, elle servira de vue d'accueille
 * 
 * @author USER
 */
@RestController // web service
@CrossOrigin
@RequestMapping ("/api") // racine projet
public class IndexRestController {
    
    @GetMapping
    public String index(){
        return "Bienvenue à Soul Quiz";
    }
}
