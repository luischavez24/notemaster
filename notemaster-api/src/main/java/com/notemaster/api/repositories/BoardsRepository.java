package com.notemaster.api.repositories;

import com.notemaster.api.entities.Boards;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public interface BoardsRepository extends MongoRepository<Boards, String>, BoardsRepositoryCustom {

}

interface BoardsRepositoryCustom {
    List<Boards> findBoardsByOwner(String owner);
}

class BoardsRepositoryImpl implements BoardsRepositoryCustom {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Boards> findBoardsByOwner(String owner) {

        List<AggregationOperation> pipeline = new ArrayList<>();

        pipeline.add(Aggregation.match(Criteria.where("owner").is(owner)));
        pipeline.add(Aggregation.lookup("notes", "notes", "_id", "notes"));

        return mongoTemplate.aggregate(Aggregation.newAggregation(pipeline),
                "boards", Boards.class).getMappedResults();
    }
}
