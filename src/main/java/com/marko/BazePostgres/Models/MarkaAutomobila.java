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
public class MarkaAutomobila {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMarke;

    private String nazivMarke;

    @ManyToOne
    @JoinColumn(name = "id_drzave", nullable = false)
    private Drzava drzava;

    @OneToMany(mappedBy = "markaAutomobila")
    private Set<ModelAutomobila> modeliAutomobila;


}
