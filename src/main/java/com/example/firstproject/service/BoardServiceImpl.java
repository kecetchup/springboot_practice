package com.example.firstproject.service;

import com.example.firstproject.domain.Board;
import com.example.firstproject.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;  // BoardRepository를 주입받습니다.

    @Override
    public List<Board> selectBoardList() {
        List<Board> boards = boardRepository.findAll();
        System.out.println("Boards retrieved: " + boards);
        return boards;
    }

    @Override
    public void insertBoard(Board board) {
        // BoardRepository의 save 메서드를 호출하여 새 게시글을 데이터베이스에 삽입합니다.
        boardRepository.save(board);
    }

    @Override
    public Board getBoardById(Long id) {
        // BoardRepository의 findById 메서드를 호출하여 주어진 id에 해당하는 게시글을 조회합니다.
        return boardRepository.findById(id).orElse(null);
    }

    @Override
    public void updateBoard(Board board) {
        // BoardRepository의 save 메서드를 호출하여 게시글을 업데이트합니다.
        // save 메서드는 기본적으로 삽입 또는 업데이트를 수행합니다.
        boardRepository.save(board);
    }

    @Override
    public void deleteBoard(Long id) {
        // BoardRepository의 deleteById 메서드를 호출하여 게시글을 삭제합니다.
        boardRepository.deleteById(id);
    }
}