package com.marko.BazePostgres.Controllers;

import com.marko.BazePostgres.Models.VrstaArtikla;
import com.marko.BazePostgres.Services.VrstaArtiklaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vrsteartikla")
public class VrstaArtiklaController {

    private final VrstaArtiklaService vrstaArtiklaService;

    @Autowired
    public VrstaArtiklaController(VrstaArtiklaService vrstaArtiklaService) {
        this.vrstaArtiklaService = vrstaArtiklaService;
    }

    @GetMapping
    public List<VrstaArtikla> getAllVrsteArtikla() {
        return vrstaArtiklaService.getAllVrsteArtikla();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VrstaArtikla> getVrstaArtiklaById(@PathVariable Integer id) {
        Optional<VrstaArtikla> vrstaArtikla = vrstaArtiklaService.getVrstaArtiklaById(id);
        return vrstaArtikla.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<VrstaArtikla> createVrstaArtikla(@RequestBody VrstaArtikla vrstaArtikla) {
        VrstaArtikla savedVrstaArtikla = vrstaArtiklaService.saveVrstaArtikla(vrstaArtikla);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVrstaArtikla);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VrstaArtikla> updateVrstaArtikla(@PathVariable Integer id, @RequestBody VrstaArtikla vrstaArtikla) {
        Optional<VrstaArtikla> existingVrstaArtiklaOpt = vrstaArtiklaService.getVrstaArtiklaById(id);
        if (existingVrstaArtiklaOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        VrstaArtikla existingVrstaArtikla = existingVrstaArtiklaOpt.get();
        existingVrstaArtikla.setNazivVrste(vrstaArtikla.getNazivVrste());

        VrstaArtikla updatedVrstaArtikla = vrstaArtiklaService.saveVrstaArtikla(existingVrstaArtikla);
        return ResponseEntity.ok(updatedVrstaArtikla);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<VrstaArtikla> partiallyUpdateVrstaArtikla(@PathVariable Integer id, @RequestBody VrstaArtikla partialVrstaArtikla) {
        Optional<VrstaArtikla> existingVrstaArtiklaOpt = vrstaArtiklaService.getVrstaArtiklaById(id);
        if (existingVrstaArtiklaOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        VrstaArtikla existingVrstaArtikla = existingVrstaArtiklaOpt.get();
        if (partialVrstaArtikla.getNazivVrste() != null) {
            existingVrstaArtikla.setNazivVrste(partialVrstaArtikla.getNazivVrste());
        }

        VrstaArtikla updatedVrstaArtikla = vrstaArtiklaService.saveVrstaArtikla(existingVrstaArtikla);
        return ResponseEntity.ok(updatedVrstaArtikla);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVrstaArtikla(@PathVariable Integer id) {
        if (vrstaArtiklaService.getVrstaArtiklaById(id).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        vrstaArtiklaService.deleteVrstaArtiklaById(id);
        return ResponseEntity.noContent().build();
    }
}
