package com.testcamp.api.models;

import com.testcamp.api.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserModel {
   public UserModel(UserDTO body) {
       this.username = body.getUsername();
       this.email = body.getEmail();
   }
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length=150, nullable = false)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;
}
