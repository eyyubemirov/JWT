package com.example.springsecurityjwt.repsitory;

import com.example.springsecurityjwt.entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

  Optional<User> findByUsername(String username);
}
