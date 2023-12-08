package com.example.aftas.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "rankings")
public class Ranking {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer rank;

    private Integer score;

}
