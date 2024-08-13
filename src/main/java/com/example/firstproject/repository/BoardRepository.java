package com.example.firstproject.repository;

import com.example.firstproject.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    // 추가적인 메서드 정의 가능

}