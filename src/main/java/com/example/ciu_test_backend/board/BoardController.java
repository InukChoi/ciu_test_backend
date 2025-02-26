package com.example.ciu_test_backend.board;

import com.example.ciu_test_backend.board.model.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/register")
    public ResponseEntity<BoardDto.ResponseDto> register(@RequestBody BoardDto.RegisterReq dto) {
        BoardDto.ResponseDto resp = boardService.createBoard(dto);
        return ResponseEntity.ok().body(resp);
    }
}
