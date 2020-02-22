package com.p7.msl.service;

import com.p7.msl.Entity.Categories;
import com.p7.msl.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {

    @Autowired
    CategorieRepository categorieRepository;

    public List<Categories> getAllCategories() {
        List<Categories> categories = new ArrayList<Categories>();
        categorieRepository.findAllByOrderByIdAsc()
                .forEach(categories::add);
        return categories;
    }

    public Optional<Categories> getCategorie(Long id) {
        return categorieRepository.findById(id);
    }

    public void addCategorie(Categories categories) {
        categorieRepository.save(categories);
    }

    public void updateCategorie(Long id, Categories categories) {
        categorieRepository.save(categories);
    }

    public void deleteCategorie(Long id) {
        categorieRepository.deleteById(id);
    }
}
