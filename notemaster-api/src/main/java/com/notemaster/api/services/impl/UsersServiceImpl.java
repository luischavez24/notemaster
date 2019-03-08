package com.notemaster.api.services.impl;

import com.notemaster.api.entities.User;
import com.notemaster.api.repositories.UsersRepository;
import com.notemaster.api.security.NotemasterUser;
import com.notemaster.api.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("userService")
public class UsersServiceImpl implements UsersService, UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public boolean existsByUsername(String username) {
        return usersRepository.existsByUsername(username);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return  usersRepository.findUserByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("The username %s doesn't exist", username)
                ));

        List<GrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });

        UserDetails userDetails = new NotemasterUser(
                user.getFirstName(),
                user.getMiddleName(),
                user.getLastName(),
                user.getUsername(),
                user.getPassword(),
                authorities
        );

        return userDetails;
    }
}
