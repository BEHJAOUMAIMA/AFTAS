package com.example.aftas.service;


import com.example.aftas.domain.Hunting;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface HuntingService {
    Hunting save(Hunting hunting);
    List<Hunting> findAll();
    Optional<Hunting> findById(Long id);
    Hunting update(Hunting huntingUpdated);
    void delete(Long id);

}
