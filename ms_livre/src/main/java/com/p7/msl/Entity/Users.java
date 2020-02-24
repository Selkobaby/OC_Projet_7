package com.p7.msl.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Users")
public class Users {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "admin")
    private boolean admin;

    @ManyToMany(mappedBy = "usersEmprunt")
    @OrderBy
    @JsonIgnore
    private Set<Emprunt> emprunts = new HashSet<Emprunt>();

}
