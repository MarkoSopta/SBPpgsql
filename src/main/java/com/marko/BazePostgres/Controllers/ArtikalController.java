package com.marko.BazePostgres.Controllers;

import com.marko.BazePostgres.Models.Artikal;
import com.marko.BazePostgres.Services.ArtikalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/artikli")
public class ArtikalController {

    private final ArtikalService artikalService;

    @Autowired
    public ArtikalController(ArtikalService artikalService) {
        this.artikalService = artikalService;
    }

    @GetMapping
    public List<Artikal> getAllArtikli() {
        return artikalService.getAllArtikli();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artikal> getArtikalById(@PathVariable Integer id) {
        Optional<Artikal> artikal = artikalService.getArtikalById(id);
        return artikal.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Artikal> createArtikal(@RequestBody Artikal artikal) {
        Artikal savedArtikal = artikalService.saveArtikal(artikal);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArtikal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artikal> updateArtikal(@PathVariable Integer id, @RequestBody Artikal artikal) {
        Optional<Artikal> existingArtikalOpt = artikalService.getArtikalById(id);
        if (existingArtikalOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Artikal existingArtikal = existingArtikalOpt.get();
        existingArtikal.setNazivArtikla(artikal.getNazivArtikla());
        existingArtikal.setSerijskiBrojArtikla(artikal.getSerijskiBrojArtikla());
        existingArtikal.setNabavnaCijena(artikal.getNabavnaCijena());
        existingArtikal.setProdajnaCijena(artikal.getProdajnaCijena());
        existingArtikal.setKolicinaDostupnog(artikal.getKolicinaDostupnog());
        existingArtikal.setVrstaArtikla(artikal.getVrstaArtikla());
        existingArtikal.setDobavljac(artikal.getDobavljac());
        existingArtikal.setProizvodac(artikal.getProizvodac());
        existingArtikal.setSkladisnoMjesto(artikal.getSkladisnoMjesto());

        Artikal updatedArtikal = artikalService.saveArtikal(existingArtikal);
        return ResponseEntity.ok(updatedArtikal);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Artikal> partiallyUpdateArtikal(@PathVariable Integer id, @RequestBody Artikal partialArtikal) {
        Optional<Artikal> existingArtikalOpt = artikalService.getArtikalById(id);
        if (existingArtikalOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Artikal existingArtikal = existingArtikalOpt.get();
        if (partialArtikal.getNazivArtikla() != null) {
            existingArtikal.setNazivArtikla(partialArtikal.getNazivArtikla());
        }
        if (partialArtikal.getSerijskiBrojArtikla() != null) {
            existingArtikal.setSerijskiBrojArtikla(partialArtikal.getSerijskiBrojArtikla());
        }
        if (partialArtikal.getNabavnaCijena() != null) {
            existingArtikal.setNabavnaCijena(partialArtikal.getNabavnaCijena());
        }
        if (partialArtikal.getProdajnaCijena() != null) {
            existingArtikal.setProdajnaCijena(partialArtikal.getProdajnaCijena());
        }
        if (partialArtikal.getKolicinaDostupnog() != null) {
            existingArtikal.setKolicinaDostupnog(partialArtikal.getKolicinaDostupnog());
        }
        if (partialArtikal.getVrstaArtikla() != null) {
            existingArtikal.setVrstaArtikla(partialArtikal.getVrstaArtikla());
        }
        if (partialArtikal.getDobavljac() != null) {
            existingArtikal.setDobavljac(partialArtikal.getDobavljac());
        }
        if (partialArtikal.getProizvodac() != null) {
            existingArtikal.setProizvodac(partialArtikal.getProizvodac());
        }
        if (partialArtikal.getSkladisnoMjesto() != null) {
            existingArtikal.setSkladisnoMjesto(partialArtikal.getSkladisnoMjesto());
        }

        Artikal updatedArtikal = artikalService.saveArtikal(existingArtikal);
        return ResponseEntity.ok(updatedArtikal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArtikal(@PathVariable Integer id) {
        if (artikalService.getArtikalById(id).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        artikalService.deleteArtikalById(id);
        return ResponseEntity.noContent().build();
    }
}
