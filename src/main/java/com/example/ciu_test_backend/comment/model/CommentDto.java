package com.example.ciu_test_backend.comment.model;

import com.example.ciu_test_backend.board.model.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class CommentDto {
    @Getter @Builder @AllArgsConstructor @NoArgsConstructor
    public static class RegisterReq{
        private Long boardIdx;
        private String content;
        private String writer;
        public Comment toEntity(Board board){
            return Comment.builder()
                    .board(board)
                    .content(content)
                    .writer(writer)
                    .build();
        }
    }

    @Getter @Builder @AllArgsConstructor @NoArgsConstructor
    public static class ResponseDto{
        private Long idx;
        private String content;
        private String writer;
        private Long boardIdx;
        public static ResponseDto fromEntity(Comment comment){
            return ResponseDto.builder()
                    .idx(comment.getIdx())
                    .content(comment.getContent())
                    .writer(comment.getWriter())
                    .boardIdx(comment.getBoard().getIdx())
                    .build();
        }
    }
}
