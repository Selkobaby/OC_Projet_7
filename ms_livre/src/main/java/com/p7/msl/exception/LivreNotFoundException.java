package com.p7.msl.exception;

public class LivreNotFoundException extends Throwable {
    public LivreNotFoundException() {
        System.out.println("Il n'y a aucun livre dans la base de données");
    }
}
