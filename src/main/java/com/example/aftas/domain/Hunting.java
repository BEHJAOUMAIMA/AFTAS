package com.example.aftas.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Hunting {

    @Id
    @GeneratedValue
    private Long id;
    private Integer umberOfFish;
}
