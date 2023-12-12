package com.example.aftas.service.Impl;

import com.example.aftas.domain.Competition;
import com.example.aftas.handler.exception.OperationException;
import com.example.aftas.repository.CompetitionRepository;
import com.example.aftas.service.CompetitionService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Component
public class CompetitionServiceImpl implements CompetitionService {

    private final CompetitionRepository competitionRepository;

    public CompetitionServiceImpl(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    @Override
    public Competition save(Competition competition) {

        Competition existingCompetition = competitionRepository.findByDate(competition.getDate());
        if (existingCompetition != null){
            throw new OperationException("There is already a competition on " + competition.getDate());
        }
        if (competition.getStartTime().isAfter(competition.getEndTime())) {
            throw new OperationException("Start time must be before end time");
        }
        String code = generateCode(competition.getLocation(), competition.getDate());
        competition.setCode(code);
        return competitionRepository.save(competition);
    }

    @Override
    public List<Competition> findAll() {
        return competitionRepository.findAll();
    }

    @Override
    public Optional<Competition> findById(Long id) {
        return competitionRepository.findById(id);
    }

    @Override
    public Competition update(Competition competitionUpdated, Long id) {

        Competition existingCompetition = competitionRepository.findById(id)
                    .orElseThrow(() -> new OperationException("Competition not found"));

        Competition competitionWithSameDate = competitionRepository.findByDate(competitionUpdated.getDate());
        if (competitionWithSameDate != null && !competitionWithSameDate.getId().equals(id)) {
            throw new OperationException("There is already a competition on " + competitionUpdated.getDate());
        }

        if (competitionUpdated.getStartTime().isAfter(competitionUpdated.getEndTime())) {
            throw new OperationException("Start time must be before end time");
        }

        existingCompetition.setDate(competitionUpdated.getDate());
        existingCompetition.setStartTime(competitionUpdated.getStartTime());
        existingCompetition.setEndTime(competitionUpdated.getEndTime());
        existingCompetition.setNumberOfParticipants(competitionUpdated.getNumberOfParticipants());
        existingCompetition.setLocation(competitionUpdated.getLocation());
        existingCompetition.setAmount(competitionUpdated.getAmount());

        if (!existingCompetition.getDate().equals(competitionUpdated.getDate()) ||
                !existingCompetition.getLocation().equals(competitionUpdated.getLocation())) {
            String code = generateCode(competitionUpdated.getLocation(), competitionUpdated.getDate());
            existingCompetition.setCode(code);
        }

        return competitionRepository.save(existingCompetition);

    }


    @Override
    public void delete(Long id) {
        competitionRepository.deleteById(id);
    }

    @Override
    public String generateCode(String location, LocalDate date) {
        String locationCode = location.substring(0, 3).toLowerCase();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yy-MM-dd");
        String formattedDate = date.format(dateFormatter);

        return locationCode + "-" + formattedDate;
    }

}
