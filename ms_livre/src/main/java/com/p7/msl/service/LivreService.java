package com.p7.msl.service;

import com.p7.msl.Entity.Livres;
import com.p7.msl.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LivreService {

    @Autowired
    private LivreRepository livreRepository;

    public List<Livres> getAllLivres() {
        List<Livres> livres = new ArrayList<Livres>();
        livreRepository.findAll()
                .forEach(livres::add);
        return livres;
    }

    public List<Livres> getLivresByAuteur(String auteur){
        List<Livres> livres = livreRepository.findByAuteur(auteur);
        return livres;
    }

    public List<Livres> getLivresByTitre(String titre){
        List<Livres> livres = livreRepository.findByTitre(titre);
        return livres;
    }

    public Optional<Livres> getLivres(Long id) {
        return livreRepository.findById(id);
    }

    public void addLivres(Livres livres) {
        livreRepository.save(livres);
    }

    public void updateLivre(Long id, Livres livre) {
        livreRepository.save(livre);
    }

    public void deleteLivres(Long id) {
        livreRepository.deleteById(id);
    }
}
