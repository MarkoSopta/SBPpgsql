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
public class Dobavljac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDobavljaca;

    private String nazivDobavljaca;
    private String racunDobavljaca;

    @OneToMany(mappedBy = "dobavljac")
    private Set<Kontakt> kontakti;

    @OneToMany(mappedBy = "dobavljac")
    private Set<Artikal> artikli;


}
