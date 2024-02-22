package com.testcamp.api.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.UUID;

@Data
public class RecipeDTO {

    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotBlank(message = "Ingredients is mandatory")
    private String ingredients;

    @NotBlank(message = "Steps is mandatory")
    private String steps;

    @NotBlank
    private UUID userId;
}
