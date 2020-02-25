package com.p7.msu.exception;

public class MailNotFoundException extends RuntimeException {
    public MailNotFoundException() {
        System.out.println("L'e-mail n'existe pas");
    }
}
