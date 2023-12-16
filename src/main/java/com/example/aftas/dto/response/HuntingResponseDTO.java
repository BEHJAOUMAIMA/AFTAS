package com.example.aftas.dto.response;

import com.example.aftas.domain.Hunting;

public record HuntingResponseDTO(
        String fish,
        Long member,
        String competition,
        Integer numberOfFish
) {

    public static HuntingResponseDTO fromHunting(Hunting hunting){
        return new HuntingResponseDTO(
                hunting.getFish() != null ? hunting.getFish().getName() : null,
                hunting.getMember() != null ? hunting.getMember().getId() : null,
                hunting.getCompetition() != null ? hunting.getCompetition().getCode() : null,
                hunting.getNumberOfFish()
        );
    }
}
