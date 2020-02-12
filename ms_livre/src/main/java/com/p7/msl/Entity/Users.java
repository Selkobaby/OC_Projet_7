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
@Table(name = "Utilisateurs")
public class Users {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Nom")
    private String nom;

    @Column(name = "Prenom")
    private String prenom;

    @Column(name = "Email")
    private String email;

    @Column(name = "Mot de Passe")
    private String password;

    @Column(name = "Admin")
    private boolean admin;

    @ManyToMany(mappedBy = "usersEmprunt")
    @OrderBy
    @JsonIgnore
    private Set<Emprunt> emprunts = new HashSet<Emprunt>();

}
