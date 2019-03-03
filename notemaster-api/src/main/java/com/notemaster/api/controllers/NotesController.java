package com.notemaster.api.controllers;

import com.notemaster.api.entities.Note;
import com.notemaster.api.services.NotesService;
import com.notemaster.api.services.UsersService;
import com.notemaster.api.util.ErrorBody;
import com.notemaster.api.util.PageWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/notes")
public class NotesController {

    @Autowired
    private NotesService notesService;

    @Autowired
    private UsersService usersService;

    @GetMapping("/{username}")
    public ResponseEntity findAllByUsername(@PathVariable String username,
                                            @RequestParam int page,
                                            @RequestParam int size) {

        // Verify if user exists
        if(usersService.existsByUsername(username)) {
            // Get requested page
            Page<Note> notePage = notesService.findAllByUser(username, page, size);
            // Wrap page
            return ResponseEntity.ok(PageWrapper.wrap(notePage));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity addNewNote(@RequestBody  Optional<Note> note) {
        if(note.isPresent()) {
            return ResponseEntity.ok(notesService.saveNote(note.get()));
        } else {
            ErrorBody body = new ErrorBody(
                    "Note cannot be null",
                    "You must pass a note in the body of the request"
            );
            return ResponseEntity.badRequest().body(body);
        }
    }
}
