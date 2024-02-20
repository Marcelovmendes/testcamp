package com.testcamp.api.controller;

import com.testcamp.api.models.RecipeModel;
import com.testcamp.api.repositories.RecipeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Optional<RecipeModel> getRecipesById(@PathVariable Long id){
        Optional<RecipeModel> recipe = recipeRepository.findById(id);
        if(!recipe.isPresent()){
            return Optional.empty();
        }
        return recipe;
    }
    @PostMapping
    public String createRecipe(@RequestBody String body){
        return body;
    }
    @PutMapping("/{id}")
    public String updateRecipe(@PathVariable Long id,@RequestBody String body){
       return body+id;
    }
    @DeleteMapping("/{id}")
    public String deleteRecipe(@PathVariable Long id){
       return "Deletando a Receita: " + id;
    }
}
