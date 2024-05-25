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
public class SkladisnoMjesto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSkladisnogMjesta;

    private String sektor;
    private String redak;
    private String stupac;
    private String polica;

    @OneToMany(mappedBy = "skladisnoMjesto")
    private Set<Artikal> artikli;


}
