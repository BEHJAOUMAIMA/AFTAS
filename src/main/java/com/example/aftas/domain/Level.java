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
@Table(name = "levels")
public class Level {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer code;

    private String description;

    private Integer points;

}
