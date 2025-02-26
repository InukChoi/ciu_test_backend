package com.example.ciu_test_backend.board;

import com.example.ciu_test_backend.board.model.Board;
import com.example.ciu_test_backend.board.model.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardDto.RegisterResp createBoard(BoardDto.RegisterReq dto) {
        Board board = boardRepository.save(dto.toEntity());
        return BoardDto.RegisterResp.fromEntity(board);
    }

    public BoardDto.ReadResp getBoard(Long idx) {
        return BoardDto.ReadResp.fromEntity(boardRepository.findById(idx).orElseThrow());
    }
}
