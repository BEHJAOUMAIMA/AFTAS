package com.example.aftas.service;


import com.example.aftas.domain.Competition;

import java.util.List;
import java.util.Optional;

public interface CompetitionService {
    Competition save(Competition competition);
    List<Competition> findAll();
    Optional<Competition> findById(Long id);
    Competition update(Competition competitionUpdated);
    void delete(Long id);
}
