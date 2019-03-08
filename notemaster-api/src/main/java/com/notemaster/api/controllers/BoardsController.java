package com.notemaster.api.controllers;

import com.notemaster.api.entities.Boards;
import com.notemaster.api.security.NotemasterUser;
import com.notemaster.api.services.BoardsService;
import com.notemaster.api.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/boards")
public class BoardsController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private BoardsService boardsService;

    @GetMapping()
    public ResponseEntity findBoardsByOwner(Authentication authentication) {
        // Verify if user exists
        String owner = authentication.getName();
        if(usersService.existsByUsername(owner)) {
            // Get requested board
            List<Boards> boards = boardsService.findBoardsByOwner(owner);
            // Wrap page
            return ResponseEntity.ok(boards);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
