package com.p7.mse.exception;

public class EmpruntNotFoundException extends Throwable {
    public EmpruntNotFoundException() {
        System.out.println("Il n'y a pas d'emprunt dans la base de donnée");
    }
} 
