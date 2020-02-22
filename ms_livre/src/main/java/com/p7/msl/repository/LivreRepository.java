package com.p7.msl.repository;

import com.p7.msl.Entity.Livres;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivreRepository extends CrudRepository <Livres, Long> {

    @Query(value = "SELECT * FROM Livres Where L.Auteur=:Auteur")
    List<Livres> findByAuteur (@Param("Auteur") String auteur);

    @Query(value = "SELECT * FROM Livres Where L.Titre=:Titre")
    List<Livres> findByTitre (@Param("Titre") String titre);
}
