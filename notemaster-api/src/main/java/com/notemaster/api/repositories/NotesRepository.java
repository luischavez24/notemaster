package com.notemaster.api.repositories;

import com.notemaster.api.entities.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends MongoRepository<Note, String> {

    Page<Note> findAllByUser(Pageable pageable, String user);

}
