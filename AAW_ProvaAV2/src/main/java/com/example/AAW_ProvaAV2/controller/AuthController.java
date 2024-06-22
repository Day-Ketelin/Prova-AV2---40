package com.example.AAW_ProvaAV2.controller;

import com.example.AAW_ProvaAV2.config.SecurityConfig;
import com.example.AAW_ProvaAV2.model.LoginRequest;
import com.example.AAW_ProvaAV2.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loja")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        String token = authService.generateToken(request.getUsername());
        return token;
    }

    @GetMapping("/username/{token}")
    public String extractUsername(@PathVariable String token) {

        String username = authService.extractUsername(token);
        return username;
    }
    @GetMapping("/cliente")
    public String getUser(Authentication authentication) {
        return "Cliente: " + authentication.getName();
    }


    // Somente o Vendedor irá acessar
    @Secured("VENDEDOR")
    @GetMapping("/vendedor")
    public String onlyVendedor(Authentication authentication) {
        return "Vendedor(a): " + authentication.getName();
    }
         @GetMapping
         public List<LoginRequest> obterTodos() {return authService.obterTodos(); }
         @GetMapping("/vendedor/{username}")
            public LoginRequest obterPorUsername(@PathVariable String username) {return authService.obterPorUsername(username); }



    // Somente o Gerente irá acessar
    @Secured("GERENTE")
    @GetMapping("/gerente")
    public String onlyGerente(Authentication authentication) {
        return "Gerente: " + authentication.getName();
    }

         @PutMapping("/gerente/{atualizar}")
         public LoginRequest atualizar(@PathVariable String username, @RequestBody LoginRequest password) {
              return authService.atualizar(username, password);
        }

        //    @GetMapping("/gerente/{detalhes}")
        //    public List<SecurityConfig> userDetailsService() {return authService.userDetailsService(); }
        @DeleteMapping("/gerente/{excluir}")
         public void excluir(@PathVariable String username) {authService.excluir(username); }


}
