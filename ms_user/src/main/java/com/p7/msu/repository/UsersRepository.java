package com.p7.msu.repository;

import com.p7.msu.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {

    @Query(value = "SELECT * FROM Users WHERE u.email = ?", nativeQuery = true)
    public Optional<Users> findByEmail(String email);
}