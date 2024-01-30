package com.example.userAuth.AulaAutenticacao.controller;

import com.example.userAuth.AulaAutenticacao.model.DTO.UserInputDTO;
import com.example.userAuth.AulaAutenticacao.model.User;
import com.example.userAuth.AulaAutenticacao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> userRegister(@RequestBody UserInputDTO userInputDTO){

        User userOutput = userService.saveUser(userInputDTO);
        URI location = UriComponentsBuilder.
                fromUriString("http://localhost:8080/user/{id}").
                buildAndExpand(userOutput.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
