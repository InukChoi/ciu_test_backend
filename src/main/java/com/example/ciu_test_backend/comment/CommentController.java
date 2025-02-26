package com.example.ciu_test_backend.comment;

import com.example.ciu_test_backend.comment.model.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/register")
    public ResponseEntity<CommentDto.ResponseDto> register(@RequestBody CommentDto.RegisterReq dto) {
        CommentDto.ResponseDto resp = commentService.register(dto);
        return ResponseEntity.ok().body(resp);
    }

}
