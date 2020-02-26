package com.p7.client.proxies;

import com.p7.client.entity.Categories;
import com.p7.client.entity.Livres;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(contextId = "msLivreProxy", name = "zuul-server")
public interface MsLivreProxy {

    @GetMapping(value = {"/ms_livre/livres"})
    List<Livres> getLivres();

    @GetMapping(value = {"/ms_livre/livres/{id}"})
    Livres getLivre( @PathVariable Long id);

    @GetMapping(value = {"/ms_livre/categories"})
    List<Categories> getCategories();

    @GetMapping(value = {"/ms_livre/categories/{categorieId}"})
    List<Livres> getLivresByCategorieId(@PathVariable Long categorieId);

    @PostMapping(value = {"/ms_livre/categorie"})
    List<Livres> getLivresByCategorie(@RequestParam Long categorieId);

    @PostMapping(value = {"/ms_livre/auteur"})
    List<Livres> getLivresByAuteur(@RequestParam String auteur);

    @PostMapping(value = {"/ms_livre/search"})
    List<Livres> getLivresByTitre(@RequestParam String titre);
}
