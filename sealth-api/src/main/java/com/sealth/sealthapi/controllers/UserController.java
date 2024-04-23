package com.sealth.sealthapi.controllers;

import com.sealth.sealthapi.dto.UpdateUserRequestDTO;
import com.sealth.sealthapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable String userId, @RequestBody UpdateUserRequestDTO request) {
        try {
            userService.updateUser(userId, request);
            return ResponseEntity.ok("Dados do usuário atualizados com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao atualizar os dados do usuário: " + e.getMessage());
        }
    }
}
