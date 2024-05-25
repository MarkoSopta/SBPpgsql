package com.marko.BazePostgres.Repositories;

import com.marko.BazePostgres.Models.Drzava;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrzavaRepository extends JpaRepository<Drzava, Integer> {
}
