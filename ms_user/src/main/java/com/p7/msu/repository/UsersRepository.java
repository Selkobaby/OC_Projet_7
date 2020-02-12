package com.p7.msu.repository;

import com.p7.msu.entity.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {

    @Query(value = "SELECT * FROM Users u WHERE u.email = ?", nativeQuery = true)
    Optional<Users> authantificationUsers (String email);
}
