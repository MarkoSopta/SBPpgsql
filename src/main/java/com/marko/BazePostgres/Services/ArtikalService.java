package com.marko.BazePostgres.Services;

import com.marko.BazePostgres.Models.Artikal;
import com.marko.BazePostgres.Repositories.ArtikalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtikalService {

    private final ArtikalRepository artikalRepository;

    @Autowired
    public ArtikalService(ArtikalRepository artikalRepository) {
        this.artikalRepository = artikalRepository;
    }

    public List<Artikal> getAllArtikli() {
        return artikalRepository.findAll();
    }

    public Optional<Artikal> getArtikalById(Integer id) {
        return artikalRepository.findById(id);
    }

    public Artikal saveArtikal(Artikal artikal) {
        return artikalRepository.save(artikal);
    }

    public void deleteArtikalById(Integer id) {
        artikalRepository.deleteById(id);
    }
}
