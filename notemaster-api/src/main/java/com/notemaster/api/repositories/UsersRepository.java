package com.notemaster.api.repositories;

import com.notemaster.api.entities.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends MongoRepository<User, String> {

    boolean existsByUsername(String username);

    Optional<User> findUserByUsername(String username);


}
