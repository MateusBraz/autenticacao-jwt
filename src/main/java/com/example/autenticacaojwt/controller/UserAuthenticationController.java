package com.example.autenticacaojwt.controller;

import com.example.autenticacaojwt.dto.input.LoginDtoInput;
import com.example.autenticacaojwt.dto.output.AuthenticationDtoOutput;
import com.example.autenticacaojwt.jwt.TokenManager;
import com.example.autenticacaojwt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/authentication")
public class UserAuthenticationController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenManager tokenManager;


    @PostMapping
    public ResponseEntity<?> authenticate(@RequestBody @Valid LoginDtoInput loginDtoInput) {
        UsernamePasswordAuthenticationToken authenticationToken = loginDtoInput.build();

        try {
            Authentication authentication = authManager.authenticate(authenticationToken);
            String jwt = tokenManager.generateToken(authentication);
            User user = (User) authentication.getPrincipal();

            AuthenticationDtoOutput authenticationDtoOutput = new AuthenticationDtoOutput(user, "Bearer", jwt);
            return ResponseEntity.ok(authenticationDtoOutput);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
