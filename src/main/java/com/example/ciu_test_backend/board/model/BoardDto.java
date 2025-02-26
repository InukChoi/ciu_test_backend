package com.example.ciu_test_backend.board.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class BoardDto {
    @Getter @Builder @AllArgsConstructor @NoArgsConstructor
    public static class RegisterReq {
        private String title;
        private String content;
        private String writer;
        public Board toEntity(){
            return Board.builder()
                    .title(title)
                    .content(content)
                    .writer(writer)
                    .commentCount(0)
                    .build();
        }
    }

    @Getter @Builder @AllArgsConstructor @NoArgsConstructor
    public static class ResponseDto{
        private Long idx;
        private String title;
        private String content;
        private String writer;
        private Integer commentCount;
        public static ResponseDto fromEntity(Board board){
            return ResponseDto.builder()
                    .idx(board.getIdx())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .writer(board.getWriter())
                    .commentCount(board.getCommentCount())
                    .build();
        }
    }
}
