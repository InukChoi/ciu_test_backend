package com.example.ciu_test_backend.comment;

import com.example.ciu_test_backend.board.BoardRepository;
import com.example.ciu_test_backend.board.model.Board;
import com.example.ciu_test_backend.comment.model.Comment;
import com.example.ciu_test_backend.comment.model.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public CommentDto.ResponseDto register(CommentDto.RegisterReq dto) {
        Board board = boardRepository.findById(dto.getBoardIdx()).orElseThrow();
        Comment comment = commentRepository.save(dto.toEntity(board));
        board.addCommentCount();
        boardRepository.save(board);
        return CommentDto.ResponseDto.fromEntity(comment);
    }
}
