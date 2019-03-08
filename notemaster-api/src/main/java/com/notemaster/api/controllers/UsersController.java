package com.notemaster.api.controllers;

import com.notemaster.api.entities.User;
import com.notemaster.api.security.NotemasterUser;
import com.notemaster.api.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/info")
    public ResponseEntity info(Authentication authentication) {

        String username = (String) authentication.getPrincipal();

        Optional<User> userOptional = usersService.findByUsername(username);
        if(userOptional.isPresent()) {
            User user = userOptional.get();
            user.setPassword(null);


            return ResponseEntity.of(Optional.of(Collections.singletonMap("user", user)));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
