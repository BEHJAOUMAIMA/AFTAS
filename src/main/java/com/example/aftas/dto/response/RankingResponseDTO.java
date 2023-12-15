package com.example.aftas.dto.response;

import com.example.aftas.domain.Ranking;

public record RankingResponseDTO(
        Long memberId,
        Long competitionId,
        Integer score,
        Integer rank
) {
    public static RankingResponseDTO fromRanking(Ranking ranking) {
        return new RankingResponseDTO(
                ranking.getMember().getId(),
                ranking.getCompetition().getId(),
                ranking.getRank(),
                ranking.getScore()
        );
    }
}
