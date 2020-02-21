package com.p7.mse.service;

import com.p7.mse.entity.Emprunt;
import com.p7.mse.repository.EmpruntRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class EmpruntService {

    @Autowired
    private EmpruntRepository empruntRepository;

    public Set<Emprunt> getAllEmprunt() {
        Set<Emprunt> emprunt = new HashSet<Emprunt>();
        empruntRepository.findAll().forEach(emprunt::add);
        return emprunt;
    }

    public Set<Emprunt> getEmpruntByLivresId(Long id) {
        Set<Emprunt> emprunt = empruntRepository.getAllEmpruntByLivres(id);
        emprunt.forEach(emprunt::add);
        return emprunt;
    }

    public Set<Emprunt> getEmpruntByUsersId(Long id) {
        Set<Emprunt> emprunt = empruntRepository.getAllEmpruntByUsers(id);
        empruntRepository.getAllEmpruntByUsers(id).forEach(emprunt::add);
        return emprunt;
    }

    public Optional<Emprunt> getEmprunt(Long id) {
        return empruntRepository.findById(id);
    }

    public void addEmprunt(Emprunt emprunt) {
        empruntRepository.save(emprunt);
    }

    public void updateEmprunt(Long id, Emprunt emprunt) {
        empruntRepository.save(emprunt);
    }

    public void deleteEmprunt(Long id) {
        empruntRepository.deleteById(id);
    }
} 
