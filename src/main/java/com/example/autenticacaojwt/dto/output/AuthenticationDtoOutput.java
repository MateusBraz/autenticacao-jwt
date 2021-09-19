package com.example.autenticacaojwt.dto.output;

import com.example.autenticacaojwt.model.User;

public class AuthenticationDtoOutput {

    private UserDtoOutput user;
    private String tokenType;
    private String token;

    public AuthenticationDtoOutput(User user, String tokenType, String token) {
        this.user = new UserDtoOutput(user);
        this.tokenType = tokenType;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public String getTokenType() {
        return tokenType;
    }

    public UserDtoOutput getUser() {
        return user;
    }

}
