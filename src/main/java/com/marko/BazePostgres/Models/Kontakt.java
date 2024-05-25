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
public class Kontakt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_kontakta")
    private Integer idKontakt;

    @ManyToOne
    @JoinColumn(name = "id_dobavljaca", nullable = false)
    private Dobavljac dobavljac;

    private String ime;
    private String prezime;
    private String email;
    private String uloga;
    private String kontakt;


}
