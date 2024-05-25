package com.marko.BazePostgres.Models;

import jakarta.persistence.*;
import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "artikal")
public class Artikal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_artikla")
    private Integer idArtikla;

    @Column(name = "naziv_artikla")
    private String nazivArtikla;

    @Column(name = "serijski_broj_artikla")
    private String serijskiBrojArtikla;

    @Column(name = "nabavna_cijena")
    private Float nabavnaCijena;

    @Column(name = "prodajna_cijena")
    private Float prodajnaCijena;

    @Column(name = "kolicina_dostupnog")
    private Integer kolicinaDostupnog;

    @ManyToOne
    @JoinColumn(name = "id_vrste_artikla", nullable = false)
    private VrstaArtikla vrstaArtikla;

    @ManyToOne
    @JoinColumn(name = "id_dobavljaca", nullable = false)
    private Dobavljac dobavljac;

    @ManyToOne
    @JoinColumn(name = "id_proizvodaca_artikla", nullable = false)
    private Proizvodac proizvodac;

    @ManyToOne
    @JoinColumn(name = "id_skladisnog_mjesta", nullable = false)
    private SkladisnoMjesto skladisnoMjesto;

    @OneToMany(mappedBy = "artikal")
    private Set<KompatibilniModel> kompatibilniModeli;
}
