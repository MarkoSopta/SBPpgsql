package com.marko.BazePostgres.Repositories;

import com.marko.BazePostgres.Models.Artikal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtikalRepository extends JpaRepository<Artikal, Integer> {
}
