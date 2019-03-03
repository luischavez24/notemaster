package com.notemaster.api.services;

import com.notemaster.api.entities.Note;
import org.springframework.data.domain.Page;

public interface NotesService {

    Page<Note> findAllByUser(String user, int page, int size);

    Note saveNote(Note noteToSave);
}
