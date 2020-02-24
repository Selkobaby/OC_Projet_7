package com.p7.msu.entity;

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
    @Column(name = "id")
    private long id;

    @Column(name = "titre")
    private String titre;

    @Column(name = "quantité")
    private int quantité;

    @Column(name = "description")
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    @OrderBy
    @JoinTable(
            name = "categorieLivre",
            joinColumns = @JoinColumn (name = "Livres_Id"),
            inverseJoinColumns =  @JoinColumn (name = "Categorie_id")
    )
    @JsonIgnore
    private Set <Categories> categorieLivre = new HashSet<Categories>();

    @Column(name = "auteur")
    private String auteur;

    @Column(name = "image")
    private String image;

}
