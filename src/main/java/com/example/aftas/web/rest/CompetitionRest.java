package com.example.aftas.web.rest;


import com.example.aftas.domain.Competition;
import com.example.aftas.dto.request.CompetitionRequestDTO;
import com.example.aftas.dto.response.CompetitionResponseDTO;
import com.example.aftas.handler.response.ResponseMessage;
import com.example.aftas.service.CompetitionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/competitions")
public class CompetitionRest {

    private final CompetitionService competitionService;

    public CompetitionRest(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @GetMapping
    public ResponseEntity<List<CompetitionResponseDTO>> getAllCompetitions() {
        List<Competition> competitions = competitionService.findAll();
        List<CompetitionResponseDTO> competitionResponseDTOS = competitions.stream()
                .map(CompetitionResponseDTO::fromCompetition)
                .toList();

        return ResponseEntity.ok(competitionResponseDTOS);
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseMessage> addCompetition(@Valid @RequestBody CompetitionRequestDTO competitionRequestDTO) {
        Competition competition = competitionService.save(competitionRequestDTO.toCompetition());
        if(competition == null) {
            return ResponseMessage.badRequest("Competition not created");
        }else {
            return ResponseMessage.created("Competition created successfully", competition);
        }
    }

    @PutMapping("/update/{competitionId}")
    public ResponseEntity<ResponseMessage> updateCompetition(@PathVariable Long competitionId, @Valid @RequestBody CompetitionRequestDTO updatedCompetitionRequestDTO) {

        Competition updatedCompetition = updatedCompetitionRequestDTO.toCompetition();
        Competition competition = competitionService.update(updatedCompetition, competitionId);

        return ResponseEntity.ok(ResponseMessage.created("Competition updated successfully", competition).getBody());
    }


}
