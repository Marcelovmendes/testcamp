package com.testcamp.api.models;

import lombok.Data;

@Data
public class RecipeModel {
    private Long id;
    private String title;
    private String ingredients;
    private String steps;
}
