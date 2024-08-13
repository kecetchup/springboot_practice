package com.example.firstproject.service;

import com.example.firstproject.domain.Board;

import java.util.List;

public interface BoardService {
    List<Board> selectBoardList();
    void insertBoard(Board board);
    Board getBoardById(Long id);
    void updateBoard(Board board);
    void deleteBoard(Long id);
}


