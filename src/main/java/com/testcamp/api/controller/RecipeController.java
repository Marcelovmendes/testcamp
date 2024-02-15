package com.testcamp.api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
   @GetMapping
    public String getRecipe(){
    return "Todas Receitas";
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
