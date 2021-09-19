package com.example.autenticacaojwt.dto.output;

import com.example.autenticacaojwt.model.User;

import java.util.Set;
import java.util.stream.Collectors;

public class UserDtoOutput {

    private String name;
    private String email;
    private Set<String> authorities;

    public UserDtoOutput(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.authorities = user.getAuthorities().stream().map(authorities -> authorities.getAuthority()).collect(Collectors.toSet());
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

}
