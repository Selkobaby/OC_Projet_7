package com.p7.mse.repository;

import com.p7.mse.entity.Emprunt;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface EmpruntRepository extends CrudRepository<Emprunt, Long> {

    @Query(value = "SELECT * FROM Emprunt WHERE e.Livre_Id = ?", nativeQuery = true)
    Set<Emprunt> getAllEmpruntByLivres (Long id);

    @Query(value = "SELECT * FROM Emprunt WHERE e.Users_Id = ?", nativeQuery = true)
    Set<Emprunt> getAllEmpruntByUsers(Long id);
}

