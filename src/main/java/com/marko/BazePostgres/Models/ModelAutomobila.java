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
public class ModelAutomobila {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idModela;

    private String nazivModela;
    private String tvornickaOznaka;
    private Integer pocetakProizvodnje;
    private Integer krajProizvodnje;

    @ManyToOne
    @JoinColumn(name = "id_marke", nullable = false)
    private MarkaAutomobila markaAutomobila;

    @OneToMany(mappedBy = "modelAutomobila")
    private Set<KompatibilniModel> kompatibilniModeli;


}
