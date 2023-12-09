package com.example.aftas.service;

import com.example.aftas.domain.Level;

import java.util.List;
import java.util.Optional;

public interface LevelService {

    Level save(Level level);
    List<Level> findAll();
    Optional<Level> findById(Long id);
    Level update(Level levelUpdated);
    void delete(Long id);

}
