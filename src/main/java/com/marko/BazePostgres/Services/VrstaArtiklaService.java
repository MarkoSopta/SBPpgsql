package com.marko.BazePostgres.Services;

import com.marko.BazePostgres.Models.VrstaArtikla;
import com.marko.BazePostgres.Repositories.VrstaArtiklaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VrstaArtiklaService {

    private final VrstaArtiklaRepository vrstaArtiklaRepository;

    @Autowired
    public VrstaArtiklaService(VrstaArtiklaRepository vrstaArtiklaRepository) {
        this.vrstaArtiklaRepository = vrstaArtiklaRepository;
    }

    public List<VrstaArtikla> getAllVrsteArtikla() {
        return vrstaArtiklaRepository.findAll();
    }

    public Optional<VrstaArtikla> getVrstaArtiklaById(Integer id) {
        return vrstaArtiklaRepository.findById(id);
    }

    public VrstaArtikla saveVrstaArtikla(VrstaArtikla vrstaArtikla) {
        return vrstaArtiklaRepository.save(vrstaArtikla);
    }

    public void deleteVrstaArtiklaById(Integer id) {
        vrstaArtiklaRepository.deleteById(id);
    }
}
