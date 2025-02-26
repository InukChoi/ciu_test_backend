package com.example.ciu_test_backend.board;

import com.example.ciu_test_backend.board.model.Board;
import com.example.ciu_test_backend.board.model.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardDto.ResponseDto createBoard(BoardDto.RegisterReq dto) {
        Board board = boardRepository.save(dto.toEntity());
        return BoardDto.ResponseDto.fromEntity(board);
    }
}
