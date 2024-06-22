package com.example.AAW_ProvaAV2.service;

import com.example.AAW_ProvaAV2.model.LoginRequest;
import com.example.AAW_ProvaAV2.repository.LojaRepository;
import com.example.AAW_ProvaAV2.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class AuthService {
    public String generateToken(String username) {
        String token = JwtUtil.generateToken(username);
        return token;
    }

    public String extractUsername(String token) {
        String username = JwtUtil.extractUsername(token);
        return username;
    }

    private LojaRepository lojaRepository;

    public List<LoginRequest> obterTodos() {return lojaRepository.findAll(); }

    public LoginRequest obterPorUsername(String username) {return lojaRepository.findById(username).orElse(null);}

    //public LoginRequest inserir(LoginRequest user) {return lojaRepository.save(user);}

    public LoginRequest atualizar(String username, LoginRequest newUser) {
        LoginRequest existingUsername = lojaRepository.findById(username).orElse(null);

        if (existingUsername != null) {
            existingUsername.setUsername(newUser.getUsername());
            existingUsername.setPassword(newUser.getPassword());
            return lojaRepository.save((existingUsername));
        } else {
            return null;
        }
    }

    public void excluir(String username) {
        lojaRepository.deleteById(username);}



    }
