package com.example.aftas.dto.request;


import com.example.aftas.domain.Competition;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDate;
import java.time.LocalTime;

public record CompetitionRequestDTO(
        @NotBlank(message = "Code cannot be blank")
        @NotNull(message = "Code cannot be null")
        String code,

        @NotNull(message = "Date cannot be null")
        @NotBlank(message = "Date cannot be blank")
        LocalDate date,
        @NotNull(message = "Start time cannot be null")
        @NotBlank(message = "Start time cannot be blank")
        LocalTime startTime,

        @NotNull(message = "End time cannot be null")
        @NotBlank(message = "End time cannot be blank")
        LocalTime endTime,

        @NotNull(message = "Number of participants cannot be null")
        @Min(value = 1, message = "Number of participants must be greater than 0")
        Integer NumberOfParticipants,

        @NotBlank(message = "Location cannot be blank")
        @NotNull(message = "Location cannot be null")
        String Location,

        @NotNull(message = "Amount cannot be null")
        @DecimalMin(value = "0.0", inclusive = false, message = "Amount must be greater than 0.0")
        Double amount

) {
    public Competition toCompetition() {
        return Competition.builder()
                .code(this.code)
                .date(this.date)
                .startTime(this.startTime)
                .endTime(this.endTime)
                .NumberOfParticipants(this.NumberOfParticipants)
                .Location(this.Location)
                .amount(this.amount)
                .build();
    }
}
