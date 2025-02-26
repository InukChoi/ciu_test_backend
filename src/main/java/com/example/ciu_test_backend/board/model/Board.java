package com.example.ciu_test_backend.board.model;

import com.example.ciu_test_backend.comment.model.Comment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String title;
    private String content;
    private String writer;

    private Integer commentCount;

    public void addCommentCount() {
        commentCount++;
    }

    public void subCommentCount() {
        commentCount--;
    }

    @OneToMany(mappedBy = "board")
    private List<Comment> comments;
}
