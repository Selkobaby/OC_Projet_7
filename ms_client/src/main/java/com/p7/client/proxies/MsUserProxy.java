package com.p7.client.proxies;

import com.p7.client.entity.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(contextId = "msUserProxy", name = "zuul-server")
public interface MsUserProxy {

    @GetMapping(value = {"/ms_user/user/{userId}"})
    Users getUserPage(@PathVariable Long userId);


    @PostMapping(value = {"/ms_user/signin"})
    Users signIn(
            @RequestParam("email") String email,
            @RequestParam("password") String password
    );

    @PostMapping(value = {"/ms_user/newUser"})
    void setPerson(
            @RequestParam("prenom") String prenom,
            @RequestParam("nom") String nom,
            @RequestParam("email") String email,
            @RequestParam("password") String password
    );
}