package com.testcamp.api.controller;

import com.testcamp.api.dtos.RecipeDTO;
import com.testcamp.api.models.RecipeModel;
import com.testcamp.api.repositories.RecipeRepository;
import com.testcamp.api.services.RecipeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
    final RecipeService recipeService;
    RecipeController(RecipeService recipeService){
        this.recipeService = recipeService;
    }
   @GetMapping
    public ResponseEntity<List<RecipeModel>> getRecipes(){
        List<RecipeModel> recipes = recipeService.findAll();
    return  ResponseEntity.status(HttpStatus.OK).body(recipes);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getRecipesById(@PathVariable UUID id){
        Optional<RecipeModel> recipe = recipeService.findById(id);
        if(!recipe.isPresent()){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Recipe not found");
        }
        return ResponseEntity.ok(recipe);
    }
    @PostMapping
    public ResponseEntity<Object> createRecipe(@RequestBody @Valid RecipeDTO body){
        Optional<RecipeModel> recipe = recipeService.save(body);
        if(!recipe.isPresent()){
           return ResponseEntity.status(HttpStatus.CONFLICT).body("A recipe with this title already exists");
        }
        return ResponseEntity.ok(recipe);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateRecipe(@PathVariable UUID id, @RequestBody @Valid RecipeDTO body){
       Optional<RecipeModel> recipe = recipeService.findById(id);
       if(!recipe.isPresent()){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Recipe not found");
       }
       return ResponseEntity.ok(recipeService.save(body));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteRecipe(@PathVariable UUID id){
        Optional<RecipeModel> recipe = recipeService.findById(id);
        if(!recipe.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Recipe not found");
        }
       return ResponseEntity.status(HttpStatus.OK).build();
    }
}
