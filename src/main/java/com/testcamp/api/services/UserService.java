package com.testcamp.api.services;

import com.testcamp.api.dtos.UserDTO;
import com.testcamp.api.models.UserModel;
import com.testcamp.api.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    final UserRepository userRepository;

    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public UserModel save(UserDTO body){
        UserModel user = new UserModel(body);
       return userRepository.save(user);
    }
}
