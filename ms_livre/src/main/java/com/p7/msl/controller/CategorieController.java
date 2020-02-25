package com.p7.msl.controller;

import com.p7.msl.entity.Categories;
import com.p7.msl.entity.Livres;
import com.p7.msl.exception.CategorieNotFoundException;
import com.p7.msl.exception.LivreNotFoundException;
import com.p7.msl.service.CategorieService;
import com.p7.msl.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @Autowired
    private LivreService livreService;


    private List<Livres> getListLivresByCategories(@PathVariable Long categorieId) throws CategorieNotFoundException {
        Categories categories;
        try {
            categories = categorieService.getCategorie(categorieId).get();
        } catch (Exception e) {
            throw new CategorieNotFoundException();
        }
        List<Livres> livres;
        try {
            livres = (List<Livres>) categories.getLivres();
        } catch (Exception e) {
            throw new CategorieNotFoundException();
        }
        return livres;
    }

    @GetMapping(value = {"/categories"})
    public List<Categories> getCategories() throws CategorieNotFoundException {
        List<Categories> categories;
        try {
            categories = categorieService.getAllCategories();
        } catch (Exception e) { ;
            throw new CategorieNotFoundException();
        }
        return categories;
    }

    @GetMapping(value = {"/category/{categoryId}"})
    public List<Livres> getLivresByCategoriesId(@PathVariable Long categoriesId) throws CategorieNotFoundException {
        return getListLivresByCategories(categoriesId);
    }

    @PostMapping(value = {"/category"})
    public List<Livres> getBooksByCategory(@RequestParam Long categoriesId) throws CategorieNotFoundException{
        Categories categories;
        try {
            categories = categorieService.getCategorie(categoriesId).get();
        } catch (Exception e) {
            throw new CategorieNotFoundException();
        }
        List<Livres> livres;
        try {
            livres = (List<Livres>) categories.getLivres();
        } catch (Exception e) {
            throw new CategorieNotFoundException();
        }
        return livres;
    }
}
