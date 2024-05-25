package com.marko.BazePostgres.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KompatibilniModel {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_artikla", nullable = false)
    private Artikal artikal;

    @ManyToOne
    @JoinColumn(name = "id_modela", nullable = false)
    private ModelAutomobila modelAutomobila;


}
