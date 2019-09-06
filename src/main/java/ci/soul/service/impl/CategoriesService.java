/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.soul.service.impl;

import ci.soul.entities.Categories;
import ci.soul.repository.CategoriesRepository;
import ci.soul.service.ICategoriesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CategoriesService redefinir les methodes de l'interface ICategoriesService
 *
 * @author USER
 */
@Service
public class CategoriesService implements ICategoriesService {

    // injection d'interface
    @Autowired
    private CategoriesRepository categoriesRepository;

    /**
     * enegistrement d'un objet
     *
     * @param categories
     * @return
     */
    @Override
    public Categories create(Categories categories) {
        return this.categoriesRepository.save(categories);
    }

    /**
     * retourne la liste d'un element 
     * @param id
     * @return 
     */
    @Override
    public Categories readOne(Integer id) {
        return this.categoriesRepository.getOne(id);
    }

    /**
     * permet de modifier un element
     * @param categories
     * @return 
     */
    @Override
    public Categories update(Categories categories) {
        return this.categoriesRepository.save(categories);
    }

    /**
     * supprime un element par l'id
     * 
     */
    @Override
    public void delete(Integer id) {
        this.categoriesRepository.deleteById(id);
    }

    /**
     * la liste de tous les elements
     * @return 
     */
    @Override
    public List<Categories> readAll() {
        return this.categoriesRepository.findAll();
    }

    // retourne un element par name
    @Override
    public Categories readOneCategoriesByName(String name) {
        // "categoriesRepository.findByName(name).orElse(null)" si existence d'objet on le retourne sinon "null"
        List<Categories> listCcategories = categoriesRepository.findByName(name).orElse(null);

        // si la liste est differente de null on retourne le prmier element
        if (!listCcategories.isEmpty()){
            return listCcategories.get(0);
        }
         return null;
    }

    // suppression de tous les elements
    @Override
    public void deleteAllCategories() {
        categoriesRepository.deleteAll();
    }

}
