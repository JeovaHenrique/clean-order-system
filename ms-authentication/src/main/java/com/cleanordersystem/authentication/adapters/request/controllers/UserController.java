package com.cleanordersystem.authentication.adapters.request.controllers;

import com.cleanordersystem.authentication.adapters.request.dto.ChangePasswordRequest;
import com.cleanordersystem.authentication.adapters.request.dto.UpdateProfileRequest;
import com.cleanordersystem.authentication.core.domain.models.User;
import com.cleanordersystem.authentication.core.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getUserEmail(@PathVariable String email) {
        Optional<User> user = userService.findByEmail(email);
        return user.map(ResponseEntity::ok).orElseGet(
                () -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .build()
        );
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.register(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<User> deleteUser(@PathVariable String email) {
        Optional<User> user = userService.findByEmail(email);

        if(user.isPresent()) {
            userService.deleteByCpf(email);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/update-profile")
    public ResponseEntity<String> updateUserProfile(@RequestBody @Valid UpdateProfileRequest request) {
        userService.updateUserProfile(request);
        return ResponseEntity.ok("Perfil atualizado com sucesso!");
    }
}
