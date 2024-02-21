package com.testcamp.api.services;

import com.testcamp.api.dtos.RecipeDTO;
import com.testcamp.api.models.RecipeModel;
import com.testcamp.api.repositories.RecipeRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RecipeService {
    final RecipeRepository recipeRepository; // instancia do repositorio

    RecipeService(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }
    public List<RecipeModel> findAll(){
        return recipeRepository.findAll();
    }
    public Optional<RecipeModel> findById(UUID id){
        return recipeRepository.findById(id);
    }
    public Optional<RecipeModel> save( RecipeDTO body){
        if(recipeRepository.existsByTitle(body.getTitle())){
            return Optional.empty();
        }
        RecipeModel recipe = new RecipeModel(body);
        return Optional.of(recipeRepository.save(recipe));
    }
    public RecipeModel update(RecipeDTO body, UUID id){
        RecipeModel newRecipe = new RecipeModel(body);
        newRecipe.setId(id);
        return recipeRepository.save(newRecipe);
    }
    public Optional<RecipeModel> delete(UUID id){
       return recipeRepository.findById(id);

    }
}
