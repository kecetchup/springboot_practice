package com.example.firstproject.DTO;

import lombok.Data;

@Data
public class BoardDTO {
    private Long boardIdx; // Long 타입으로 변경
    private String title;
    private String content;
    private int hitCnt;
    private String creatorId;
    private String createDate;
    private String updateId;
    private String updateDate;
}