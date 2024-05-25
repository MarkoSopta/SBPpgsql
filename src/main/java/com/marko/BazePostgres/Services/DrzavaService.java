package com.marko.BazePostgres.Services;

import com.marko.BazePostgres.Models.Drzava;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.marko.BazePostgres.Repositories.DrzavaRepository;
import java.util.List;
import java.util.Optional;

@Service
public class DrzavaService {

    private final DrzavaRepository drzavaRepository;

    @Autowired
    public DrzavaService(DrzavaRepository drzavaRepository) {
        this.drzavaRepository = drzavaRepository;
    }

    public List<Drzava> getAllDrzave() {
        return drzavaRepository.findAll();
    }

    public Optional<Drzava> getDrzavaById(Integer id) {
        return drzavaRepository.findById(id);
    }

    public Drzava saveDrzava(Drzava drzava) {
        return drzavaRepository.save(drzava);
    }

    public void deleteDrzavaById(Integer id) {
        drzavaRepository.deleteById(id);
    }
}
