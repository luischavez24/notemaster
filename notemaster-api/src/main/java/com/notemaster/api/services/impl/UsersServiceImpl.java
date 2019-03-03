package com.notemaster.api.services.impl;

import com.notemaster.api.repositories.UsersRepository;
import com.notemaster.api.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public boolean existsByUsername(String username) {
        return usersRepository.existsByUsername(username);
    }
}
