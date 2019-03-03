package com.notemaster.api.services.impl;

import com.notemaster.api.entities.Note;
import com.notemaster.api.repositories.NotesRepository;
import com.notemaster.api.services.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("notesService")
public class NotesServiceImpl implements NotesService {

    @Autowired
    private NotesRepository notesRepository;

    @Override
    public Page<Note> findAllByUser(String user, int page, int size) {

        // Creating pageRequest
        PageRequest pageRequest = PageRequest.of(page - 1, size);

        return notesRepository.findAllByUser(pageRequest, user);
    }

    @Override
    public Note saveNote(Note noteToSave) {
        return notesRepository.save(noteToSave);
    }
}
