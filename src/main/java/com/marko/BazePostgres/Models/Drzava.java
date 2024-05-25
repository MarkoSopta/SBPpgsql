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
@Table(name = "drzava", schema = "auto_dijelovi")
public class Drzava {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDrzave;

    private String nazivDrzave;

    @OneToMany(mappedBy = "drzava")
    private Set<Proizvodac> proizvodaci;

    @OneToMany(mappedBy = "drzava")
    private Set<MarkaAutomobila> markeAutomobila;


}
