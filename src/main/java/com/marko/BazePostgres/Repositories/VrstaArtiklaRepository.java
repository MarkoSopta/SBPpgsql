package com.marko.BazePostgres.Repositories;

import com.marko.BazePostgres.Models.VrstaArtikla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VrstaArtiklaRepository extends JpaRepository<VrstaArtikla, Integer> {
}
