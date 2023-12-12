package com.example.aftas.dto.request;

import com.example.aftas.domain.Fish;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record FishRequestDTO(

        @NotBlank
        @NotNull(message = "the Fish name cannot be null")
        @Size(min = 1, max = 50, message = "Name must be between 1 and 50 characters")
        String name,

        @Positive(message = "Average weight must be a positive number")
        Double averageWeight

) {

    public Fish toFish(){
        return Fish.builder()
                .name(this.name)
                .averageWeight(this.averageWeight)
                .build();
    }
}
