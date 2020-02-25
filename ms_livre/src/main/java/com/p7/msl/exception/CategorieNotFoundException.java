package com.p7.msl.exception;

public class CategorieNotFoundException extends Throwable {
    public CategorieNotFoundException() {
        System.out.println("Il n'y a pas de catégorie dans la base de données");
    }
}
