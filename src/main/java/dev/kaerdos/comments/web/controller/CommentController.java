package dev.kaerdos.comments.web.controller;

import dev.kaerdos.comments.domain.dto.CommentRequest;
import dev.kaerdos.comments.domain.dto.CommentResponse;
import dev.kaerdos.comments.domain.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public ResponseEntity<List<CommentResponse>> getAllComments() {
        return ResponseEntity.ok(commentService.getAllComments());
    }

    @GetMapping("/{post}")
    public ResponseEntity<List<CommentResponse>> getCommentsByPost(@PathVariable String post) {
        return ResponseEntity.ok(commentService.getCommentsByPost(post));
    }

    @PostMapping
    public ResponseEntity<CommentResponse> postComment(@Valid @RequestBody CommentRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.postNewComment(request));
    }
}
