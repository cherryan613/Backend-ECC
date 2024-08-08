package com.example.backend.api;

import com.example.backend.dto.CommentDto;
import com.example.backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentApiController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/api/products/{product_code}/comments")
    public ResponseEntity<List<CommentDto>> comments(@PathVariable Long product_code) {
        // 서비스에 위임
        List<CommentDto> dtos = commentService.comments(product_code);
        // 결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    // 2. 댓글 생성
    @PostMapping("/api/products/{product_code}/comments")
    public ResponseEntity<CommentDto> create(@PathVariable Long product_code, @RequestBody CommentDto dto) {
        // 서비스에 위임
        CommentDto createdDto = commentService.create(product_code, dto);
        // 결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }

    // 3. 댓글 수정
    @PatchMapping("/api/comments/{comment_code}")
    public ResponseEntity<CommentDto> update(@PathVariable Long comment_code, @RequestBody CommentDto dto) {
        // 서비스에 위임
        CommentDto updatedDto = commentService.update(comment_code, dto);
        // 결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(updatedDto);
    }

    // 4. 댓글 삭제
    @DeleteMapping("/api/comments/{comment_code}")
    public ResponseEntity<CommentDto> delete(@PathVariable Long comment_code) {
        // 서비스에 위임
        CommentDto deletedDto = commentService.delete(comment_code);
        // 결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(deletedDto);
    }
}