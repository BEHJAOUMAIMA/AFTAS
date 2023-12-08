package com.example.aftas.service;



import com.example.aftas.domain.Ranking;

import java.util.List;
import java.util.Optional;

public interface RankingService {

    Ranking save(Ranking ranking);
    List<Ranking> findAll();
    Optional<Ranking> findById(Long id);
    Ranking update(Ranking rankingUpdated);
    void delete(Long id);

}
