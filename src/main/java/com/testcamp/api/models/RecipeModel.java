package com.testcamp.api.models;

import com.testcamp.api.dtos.RecipeDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
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
        this.user = new UserModel();
        this.user.setId(dto.getUserId());
    }
    public  RecipeModel(RecipeDTO dto,UserModel user, List<CategoryModel> categories){
        this.title = dto.getTitle();
        this.ingredients = dto.getIngredients();
        this.steps = dto.getSteps();
        this.user = user;
        this.categories = categories;

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


    @ManyToMany
    @JoinTable(
            name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipeId"),
            inverseJoinColumns = @JoinColumn(name= "categoryId")
    )
    private List<CategoryModel> categories;
}
