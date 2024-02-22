package com.testcamp.api.services;

import com.testcamp.api.dtos.RecipeDTO;
import com.testcamp.api.models.RecipeModel;
import com.testcamp.api.models.UserModel;
import com.testcamp.api.repositories.RecipeRepository;
import com.testcamp.api.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RecipeService {
    final RecipeRepository recipeRepository; // instancia do repositorio
    final UserRepository userRepository;


    RecipeService(RecipeRepository recipeRepository, UserRepository userRepository){
        this.recipeRepository = recipeRepository;
        this.userRepository = userRepository;
    }
    public List<RecipeModel> findAll(){
        return recipeRepository.findAll();
    }
    public Optional<RecipeModel> findById(Long id){
        return recipeRepository.findById(id);
    }
    public Optional<RecipeModel> save( RecipeDTO body){
        if(recipeRepository.existsByTitle(body.getTitle())){
            return Optional.empty();
        }
        Optional<UserModel> user = userRepository.findById(body.getUserId());
        if(!user.isPresent()){
            return Optional.empty();
        }
        RecipeModel recipe = new RecipeModel(body, user.get());
        return Optional.of(recipeRepository.save(recipe));
    }
    public RecipeModel update(RecipeDTO body, Long id){
        RecipeModel newRecipe = new RecipeModel(body);
        newRecipe.setId(id);
        return recipeRepository.save(newRecipe);
    }
    public Optional<RecipeModel> delete(Long id){
       return recipeRepository.findById(id);
    }
}
