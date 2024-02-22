package com.testcamp.api.models;

import com.testcamp.api.dtos.RecipeDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "recipes")
public class RecipeModel {
   public  RecipeModel(RecipeDTO dto){
        this.title = dto.getTitle();
        this.ingredients = dto.getIngredients();
        this.steps = dto.getSteps();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column()
    private String title;

    @Column()
    private String ingredients;

    @Column()
    private String steps;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserModel user;

}
