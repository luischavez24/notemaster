package com.notemaster.api.services;

import com.notemaster.api.entities.Note;
import org.springframework.data.domain.Page;

public interface NotesService {

    Note saveNote(Note noteToSave);
}
