package com.example.autenticacaojwt.service;

import com.example.autenticacaojwt.model.User;
import com.example.autenticacaojwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> possibleUser = userRepository.findByEmail(username);
        return possibleUser.orElseThrow(() -> new UsernameNotFoundException(String.format("Não existe um usuário com o e-mail: %s", username)));
    }

    public UserDetails loadUserById(Long userId) {
        Optional<User> possibleUser = userRepository.findById(userId);
        return possibleUser.orElseThrow(() -> new UsernameNotFoundException(String.format("Não foi possível encontrar o usuário com id: %d", userId)));
    }
    
}
