package com.p7.client.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Emprunt")
public class Emprunt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "secondEmprunt")
    private boolean secondEmprunt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Livres_Id")
    @OrderBy
    @JsonIgnore
    private Livres livres;

    @ManyToMany
    @JoinTable(
            name = "usersEmprunt",
            joinColumns = @JoinColumn(name = "Emprunt_Id"),
            inverseJoinColumns = @JoinColumn(name = "Users_Id")
    )
    @OrderBy
    @JsonIgnore
    private List<Users> usersEmprunt = new ArrayList<Users>();

}
