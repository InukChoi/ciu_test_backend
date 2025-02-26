package com.example.ciu_test_backend.board.model;

import com.example.ciu_test_backend.comment.model.Comment;
import com.example.ciu_test_backend.comment.model.CommentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

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
    public static class RegisterResp {
        private Long idx;
        private String title;
        private String content;
        private String writer;
        private Integer commentCount;
        public static RegisterResp fromEntity(Board board){
            return RegisterResp.builder()
                    .idx(board.getIdx())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .writer(board.getWriter())
                    .commentCount(board.getCommentCount())
                    .build();
        }
    }

    @Getter @Builder @AllArgsConstructor @NoArgsConstructor
    public static class ReadResp {
        private Long idx;
        private String title;
        private String content;
        private String writer;
        private List<CommentDto.ResponseDto> comments;
        public static ReadResp fromEntity(Board board){
            return ReadResp.builder()
                    .idx(board.getIdx())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .writer(board.getWriter())
                    .comments(board.getComments().stream().map(CommentDto.ResponseDto::fromEntity).collect(Collectors.toList()))
                    .build();
        }
    }
}
