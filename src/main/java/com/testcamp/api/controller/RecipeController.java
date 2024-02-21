package com.testcamp.api.controller;

import com.testcamp.api.dtos.RecipeDTO;
import com.testcamp.api.models.RecipeModel;
import com.testcamp.api.repositories.RecipeRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
    final RecipeRepository recipeRepository;
    RecipeController(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }
   @GetMapping
    public List getRecipe(){
    return recipeRepository.findAll();
    }
    @GetMapping("/{id}")
    public Optional<RecipeModel> getRecipesById(@PathVariable UUID id){
        Optional<RecipeModel> recipe = recipeRepository.findById(id);
        if(!recipe.isPresent()){
            return Optional.empty();
        }
        return recipe;
    }
    @PostMapping
    public RecipeModel createRecipe(@RequestBody @Valid RecipeDTO body){
        RecipeModel recipe = new RecipeModel(body);
       return recipeRepository.save(recipe);
    }
    @PutMapping("/{id}")
    public RecipeModel updateRecipe(@PathVariable UUID id, @RequestBody @Valid RecipeDTO body){
       Optional<RecipeModel> recipe = recipeRepository.findById(id);
       if(!recipe.isPresent()){

       }
       RecipeModel newRecipe = new RecipeModel(body);
       newRecipe.setId(id);
       return recipeRepository.save(newRecipe);
    }
    @DeleteMapping("/{id}")
    public Valid deleteRecipe(@PathVariable UUID id){
        recipeRepository.deleteById(id);
    }
}
