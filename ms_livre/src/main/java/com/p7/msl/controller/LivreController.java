package com.p7.msl.controller;

import com.p7.msl.entity.Categories;
import com.p7.msl.entity.Livres;
import com.p7.msl.exception.LivreNotFoundException;
import com.p7.msl.service.CategorieService;
import com.p7.msl.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LivreController {

    @Autowired
    private LivreService livreService;

    @Autowired
    private CategorieService categorieService;

    private List<Livres> getListLivresByCategories(@PathVariable Long categorieId) throws LivreNotFoundException {
        Categories categories;
        try {
            categories = categorieService.getCategorie(categorieId).get();
        } catch (Exception e) {
            throw new LivreNotFoundException();
        }
        List<Livres> livres;
        try {
            livres = (List<Livres>) categories.getLivres();
        } catch (Exception e) {
            throw new LivreNotFoundException();
        }
        return livres;
    }


    @GetMapping(value = {"/livres"})
    public  List<Livres> getLivres() throws LivreNotFoundException {
        List<Livres> livres = livreService.getAllLivres();
        if(livres == null) {
            throw new LivreNotFoundException();
        }
        return livres;
    }

    @GetMapping(value = {"/livre/{id}"})
    public Livres getLivres(@PathVariable Long id) throws LivreNotFoundException {
        Livres livres = null;
        try {
            livres = livreService.getLivres(id).orElseThrow (() -> new LivreNotFoundException());
        }
        catch(Exception e) {
            System.out.println();
        }
        return livres;
    }

    @PostMapping(value = {"/auteur"})
    public List<Livres> getLivresByAuteur(@RequestParam String auteur) throws LivreNotFoundException {
        List<Livres> livres;
        try {
            livres = livreService.getLivresByAuteur(auteur);
        } catch (Exception e) {
            throw new LivreNotFoundException();
        }
        return livres;
    }

    @PostMapping(value = {"/search"})
    public List<Livres> getLivresByTitre(@RequestParam String titre) throws LivreNotFoundException{
        List<Livres> livres;
        try {
            livres = livreService.getLivresByTitre(titre);
        } catch (Exception e) {
            throw new LivreNotFoundException();
        }
        return livres;
    }
}
