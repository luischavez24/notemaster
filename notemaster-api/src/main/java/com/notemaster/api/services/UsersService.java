package com.notemaster.api.services;

import com.notemaster.api.entities.User;

import java.util.Optional;

public interface UsersService {

    boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);

}
