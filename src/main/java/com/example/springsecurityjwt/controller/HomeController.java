package com.example.springsecurityjwt.controller;

import com.example.springsecurityjwt.entitiy.AuthRequest;
import com.example.springsecurityjwt.entitiy.User;
import com.example.springsecurityjwt.repsitory.UserRepository;
import com.example.springsecurityjwt.service.JwtService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class HomeController {
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    @GetMapping("/")
    public String helloJwt() {
        return "Hello jwt";
    }
    @GetMapping("/get")
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (Exception e) {
            throw new Exception("Invalid username or password");
        }
        return jwtService.generateToken(authRequest.getUsername());

    }
}

