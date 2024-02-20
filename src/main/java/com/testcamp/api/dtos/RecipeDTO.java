package com.testcamp.api.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RecipeDTO {

    @NotBlank
    private String title;

    @NotBlank
    private String ingredients;

    @NotBlank
    private String steps;
}
