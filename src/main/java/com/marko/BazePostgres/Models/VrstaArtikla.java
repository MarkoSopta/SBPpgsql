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
public class VrstaArtikla {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVrsteArtikla;

    private String nazivVrste;

    @OneToMany(mappedBy = "vrstaArtikla")
    private Set<Artikal> artikli;


}
