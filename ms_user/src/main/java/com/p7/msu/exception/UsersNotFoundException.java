package com.p7.msu.exception;

public class UsersNotFoundException extends RuntimeException{
    public UsersNotFoundException() {
        System.out.println("L'utilisateur n'existe pas");
    }
} 
