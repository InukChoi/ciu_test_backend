package com.example.ciu_test_backend.board;

import com.example.ciu_test_backend.board.model.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/register")
    public ResponseEntity<BoardDto.RegisterResp> register(@RequestBody BoardDto.RegisterReq dto) {
        BoardDto.RegisterResp resp = boardService.createBoard(dto);
        return ResponseEntity.ok().body(resp);
    }

    @GetMapping("/read/{idx}")
    public ResponseEntity<BoardDto.ReadResp> read(@PathVariable Long idx) {
        BoardDto.ReadResp resp = boardService.getBoard(idx);
        return ResponseEntity.ok().body(resp);
    }

    @GetMapping("/list")
    public ResponseEntity<BoardDto.ListResp> list(int page, int size) {
        BoardDto.ListResp resp = boardService.getBoards(page,  size);
        return ResponseEntity.ok().body(resp);
    }
}
