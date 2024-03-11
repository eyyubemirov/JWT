package com.example.springsecurityjwt;

import com.example.springsecurityjwt.entitiy.User;
import com.example.springsecurityjwt.repsitory.UserRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@Req
public class SpringSecurityJwtApplication {
private final UserRepository userRepository;
@PostConstruct
    public  void  createUsers(){
        List<User> users= Stream.of(
                new User(1,"Eyyub","{noop}password","eyyubemirov9."),
                new User(2,"Elsad","{noop}1234","eyyubemirov9."),
                new User(3,"Elmar","{noop}2222","eyyubemirov9."),
                new User(4,"Elman","{noop}3333","eyyubemirov9.")
        ).collect(Collectors.toList());
        userRepository.saveAll(users);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtApplication.class, args);
    }

}
