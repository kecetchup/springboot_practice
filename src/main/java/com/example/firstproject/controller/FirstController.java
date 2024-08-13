package com.example.firstproject.controller;

import com.example.firstproject.domain.Board;
import com.example.firstproject.DTO.BoardDTO;
import com.example.firstproject.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class FirstController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/boardList")
    public String boardList(Model model) {
        List<Board> list = boardService.selectBoardList();
        model.addAttribute("list", list);
        return "boardListView"; // Thymeleaf 템플릿 파일
    }

    @GetMapping("/board/{id}")
    public String boardDetails(@PathVariable("id") Long id, Model model) {
        Board board = boardService.getBoardById(id);
        model.addAttribute("board", board);
        return "boardDetailView"; // 게시글 상세보기 템플릿 파일
    }

    @GetMapping("/board/new")
    public String newBoardForm(Model model) {
        model.addAttribute("boardDTO", new BoardDTO());
        return "boardForm"; // 게시글 작성 폼 템플릿
    }

    @PostMapping("/board")
    public String createBoard(@ModelAttribute BoardDTO boardDTO) {
        Board board = new Board();
        board.setTitle(boardDTO.getTitle());
        board.setContent(boardDTO.getContent());
        board.setCreatorId(boardDTO.getCreatorId());
        // 필요한 경우 추가 필드 설정

        boardService.insertBoard(board);
        return "redirect:/boardList"; // 게시글 목록으로 리다이렉트
    }

    @GetMapping("/board/edit/{id}")
    public String editBoardForm(@PathVariable("id") Long id, Model model) {
        Board board = boardService.getBoardById(id);
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setBoardIdx(board.getBoardIdx());
        boardDTO.setTitle(board.getTitle());
        boardDTO.setContent(board.getContent());
        boardDTO.setCreatorId(board.getCreatorId());
        // 필요한 경우 추가 필드 설정

        model.addAttribute("boardDTO", boardDTO);
        return "boardForm"; // 게시글 수정 폼 템플릿
    }

    @PostMapping("/board/update")
    public String updateBoard(@ModelAttribute BoardDTO boardDTO) {
        Board board = new Board();
        board.setBoardIdx(boardDTO.getBoardIdx());
        board.setTitle(boardDTO.getTitle());
        board.setContent(boardDTO.getContent());
        board.setCreatorId(boardDTO.getCreatorId());
        // 필요한 경우 추가 필드 설정

        boardService.updateBoard(board);
        return "redirect:/boardList"; // 게시글 목록으로 리다이렉트
    }

    @PostMapping("/board/delete/{id}")
    public String deleteBoard(@PathVariable("id") Long id) {
        boardService.deleteBoard(id);
        return "redirect:/boardList"; // 게시글 목록으로 리다이렉트
    }
}
