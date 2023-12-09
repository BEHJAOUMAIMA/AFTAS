package com.example.aftas.service;

import com.example.aftas.domain.Fish;

import java.util.List;
import java.util.Optional;

public interface FishService {

    Fish save(Fish fish);
    List<Fish> findAll();
    Optional<Fish> findById(Long id);
    Fish update(Fish fishUpdated);
    void delete(Long id);

}
