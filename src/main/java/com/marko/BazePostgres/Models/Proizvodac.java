package com.marko.BazePostgres.Models;

import jakarta.persistence.*;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Proizvodac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProizvodaca;

    private String nazivProizvodaca;
    private String adresaProizvodaca;
    private String emailProizvodaca;
    private String telefonProizvodaca;

    @ManyToOne
    @JoinColumn(name = "id_drzave", nullable = false)
    private Drzava drzava;

    @OneToMany(mappedBy = "proizvodac")
    private Set<Artikal> artikli;


}
