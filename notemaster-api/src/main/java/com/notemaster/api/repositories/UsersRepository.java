package com.notemaster.api.repositories;

import com.notemaster.api.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends MongoRepository<User, String> {

    boolean existsByUsername(String username);

}
