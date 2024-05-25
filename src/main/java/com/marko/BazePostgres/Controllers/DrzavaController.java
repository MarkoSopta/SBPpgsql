package com.marko.BazePostgres.Controllers;

import com.marko.BazePostgres.Models.Drzava;
import com.marko.BazePostgres.Services.DrzavaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/drzave")
public class DrzavaController {

    private final DrzavaService drzavaService;

    @Autowired
    public DrzavaController(DrzavaService drzavaService) {
        this.drzavaService = drzavaService;
    }

    @GetMapping
    public List<Drzava> getAllDrzave() {
        return drzavaService.getAllDrzave();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Drzava> getDrzavaById(@PathVariable Integer id) {
        Optional<Drzava> drzava = drzavaService.getDrzavaById(id);
        return drzava.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Drzava> createDrzava(@RequestBody Drzava drzava) {
        Drzava savedDrzava = drzavaService.saveDrzava(drzava);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDrzava);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Drzava> updateDrzava(@PathVariable Integer id, @RequestBody Drzava drzava) {
        Optional<Drzava> existingDrzavaOpt = drzavaService.getDrzavaById(id);
        if (existingDrzavaOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Drzava existingDrzava = existingDrzavaOpt.get();
        existingDrzava.setNazivDrzave(drzava.getNazivDrzave());

        existingDrzava.setProizvodaci(drzava.getProizvodaci());
        existingDrzava.setMarkeAutomobila(drzava.getMarkeAutomobila());

        Drzava updatedDrzava = drzavaService.saveDrzava(existingDrzava);
        return ResponseEntity.ok(updatedDrzava);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Drzava> partiallyUpdateDrzava(@PathVariable Integer id, @RequestBody Drzava partialDrzava) {
        Optional<Drzava> existingDrzavaOpt = drzavaService.getDrzavaById(id);
        if (existingDrzavaOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Drzava existingDrzava = existingDrzavaOpt.get();
        if (partialDrzava.getNazivDrzave() != null) {
            existingDrzava.setNazivDrzave(partialDrzava.getNazivDrzave());
        }

        // Update other fields similarly if needed
        if (partialDrzava.getProizvodaci() != null) {
            existingDrzava.setProizvodaci(partialDrzava.getProizvodaci());
        }
        if (partialDrzava.getMarkeAutomobila() != null) {
            existingDrzava.setMarkeAutomobila(partialDrzava.getMarkeAutomobila());
        }

        Drzava updatedDrzava = drzavaService.saveDrzava(existingDrzava);
        return ResponseEntity.ok(updatedDrzava);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDrzava(@PathVariable Integer id) {
        if (!drzavaService.getDrzavaById(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        drzavaService.deleteDrzavaById(id);
        return ResponseEntity.noContent().build();
    }
}
