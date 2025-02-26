package com.example.ciu_test_backend.board;

import com.example.ciu_test_backend.board.model.Board;
import com.example.ciu_test_backend.board.model.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public BoardDto.ListResp getBoards(int page, int size) {
        Page<Board> boards = boardRepository.findAll(PageRequest.of(page, size));
        List<BoardDto.RegisterResp> items = boards.getContent().stream().map(BoardDto.RegisterResp::fromEntity).collect(Collectors.toList());
        return BoardDto.ListResp.builder()
                .total(boards.getTotalPages())
                .boards(items)
                .build();
    }
}
