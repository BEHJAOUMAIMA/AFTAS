package com.example.aftas.dto.request;

import com.example.aftas.domain.Level;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record LevelRequestDTO(

        @NotBlank(message = "Level Code cannot be blank")
        @NotNull(message = "Level Code cannot be null")
        @Min(value = 1, message = "Level Code must be greater than or equal to 1")
        Integer code,

        @NotNull(message = "Description of Level cannot be Null")
        @NotBlank(message = "Description of Level cannot be blank")
        String description,

        @NotNull(message = "Points cannot be null")
        @Positive(message = "Points must be a positive number")
        Integer points
) {

    public Level toLevel(){
        return Level.builder()
                .code(this.code)
                .description(this.description)
                .points(this.points).build();

    }
}
