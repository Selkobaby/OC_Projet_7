package com.p7.client.entity;

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
@Table(name = "Livres")
public class Livres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long id;

    @Column(name = "Titre")
    private String titre;

    @Column(name = "Description")
    private String description;

    @Column(name = "Categorie")
    @ManyToMany(fetch = FetchType.EAGER)
    @OrderBy
    @JoinTable(
            joinColumns = @JoinColumn (name = "Livres_Id"),
            inverseJoinColumns =  @JoinColumn (name = "Categorie_id")
    )
    @JsonIgnore
    private Set <Categories> categorieLivre = new HashSet<Categories>();

    @Column(name = "Auteur")
    private String auteur;

    @Column(name = "Image")
    private String image;

    @Column(name = "Quantité")
    private int quantite;


}
