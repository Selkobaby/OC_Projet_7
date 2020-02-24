package com.p7.msu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {

    @Query(value = "SELECT * FROM Users WHERE U.Email = ?", nativeQuery = true)
    Optional<Users> findByEmail(String email);
}