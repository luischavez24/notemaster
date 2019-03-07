package com.notemaster.api.services;

import com.notemaster.api.entities.Boards;

import java.util.List;

public interface BoardsService {

    List<Boards> findBoardsByOwner(String owner);

}
