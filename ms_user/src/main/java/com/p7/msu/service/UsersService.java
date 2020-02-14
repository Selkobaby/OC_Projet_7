package com.p7.msu.service;

import com.p7.msu.entity.Users;
import com.p7.msu.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


public class UsersService {

    @Autowired
    private UsersRepository usersRepository;


    public Optional<Users> getUsersById(Long id) {
        return usersRepository.findById(id);
    }

    public Optional<Users> usersByMail (String email) {
        Optional<Users> personByMail = usersRepository.findByEmail(email);
        return personByMail;
    }

    public Set<Users> getAllUsers() {
        Set<Users> persons = new HashSet<Users>();
        usersRepository.findAll().forEach(persons::add);
        return persons;
    }

    public void addUsers(Users users) {
        String rawPassword = users.getPassword();
        users.setPassword(BCrypt.hashpw(rawPassword, BCrypt.gensalt(10)));
        usersRepository.save(users);
    }

    public void updateUsers(Long id, Users users) {
        usersRepository.save(users);
    }

    public void deleteUsers(Long id) {
        usersRepository.deleteById(id);
    }

}