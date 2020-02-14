package com.p7.msu.controller;

import com.p7.msu.entity.Users;
import com.p7.msu.exception.UsersNotFoundException;
import com.p7.msu.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/users")
    public Users save(@RequestBody Users users){
        return usersService.addUsers();
    }

    @GetMapping("/users/{id}")
    public Users getById(@PathVariable(value = "id") Long usersId){
        Users users = null;
        try{
        users = usersService.getUsersById(usersId).orElseThrow( () ->
                new UsersNotFoundException("Il n'y a pas d'utilsateur avec cet identifiant" +usersId));
    } catch (Exception e){
        System.out.println("Il n'y a pas d'utilisateur avec cet identifiant " + usersId + " " + e);
    }
        return users;
    }

    @GetMapping("/users")
    public List<Users> getAll(){
        return usersService.findAll();
    }

    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable(value = "id") Long id){
        usersService.deleteUsers();
    }

    @DeleteMapping("/users")
    public void deleteAll(){
        usersService.deleteAll();
    }

    @GetMapping("/users/count")
    public long count(){
        return usersService.count();
    }
}