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
    public Note saveNote(Note noteToSave) {
        return notesRepository.save(noteToSave);
    }
}
