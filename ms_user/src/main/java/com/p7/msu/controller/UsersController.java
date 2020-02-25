package com.p7.msu.controller;

import com.p7.msu.entity.Users;
import com.p7.msu.exception.MailNotFoundException;
import com.p7.msu.exception.UsersNotFoundException;
import com.p7.msu.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users/{id}")
    public Users getById(@PathVariable(value = "id") Long usersId){
        Users users = null;
        try{
            users = usersService.getUsersById(usersId).orElseThrow( () ->
                    new UsersNotFoundException());
        } catch (Exception e){
            throw new UsersNotFoundException();
        }
        return users;
    }


    @PostMapping("/sign in")
    public Users signIn( @RequestParam("email") String email, @RequestParam("password") String password) {

            Users users = null;
            if(usersService.passwordOk(email, password)) {
                try {
                    users = usersService.usersByMail(email).orElseThrow(() ->
                            new MailNotFoundException()
                    );
                } catch(Exception e) {
                   throw new MailNotFoundException();

                }
            } else {
                System.out.println("L'utilisateur ou le mot de passe est mauvais");
            }
            return users;
        }

    @PostMapping(value = {"/newUsers"})
    public void setPerson(
            @RequestParam("prenom") String nom,
            @RequestParam("nom") String prenom,
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ) {
        Users users= new Users();
        users.setNom(nom);
        users.setPrenom(prenom);
        users.setEmail(email);
        users.setPassword(password);
        users.setAdmin(false);
        usersService.addUsers(users);
    }

}