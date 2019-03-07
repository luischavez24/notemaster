package com.notemaster.api.services.impl;

import com.notemaster.api.entities.Boards;
import com.notemaster.api.repositories.BoardsRepository;
import com.notemaster.api.services.BoardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("boardsService")
public class BoardsServiceImpl implements BoardsService {
    @Autowired
    private BoardsRepository groupsRepository;

    @Override
    public List<Boards> findBoardsByOwner(String owner) {
        return groupsRepository.findBoardsByOwner(owner);
    }
}
