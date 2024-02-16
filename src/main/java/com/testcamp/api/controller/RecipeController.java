package com.testcamp.api.controller;

import com.testcamp.api.repositories.RecipeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String getRecipesById(@PathVariable Long id){
       return "Essa é a Receita: "+ id;
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
