package dev.kaerdos.comments.domain.service;

import dev.kaerdos.comments.domain.dto.CommentRequest;
import dev.kaerdos.comments.domain.dto.CommentResponse;
import dev.kaerdos.comments.domain.repository.CommentRepository;
import dev.kaerdos.comments.persistence.entity.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<CommentResponse> getAllComments() {
        return commentRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public List<CommentResponse> getCommentsByPost(String post) {
        return commentRepository.findByPost(post)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public List<CommentResponse> getCommentsByUsername(String username) {
        return commentRepository.findByUsername(username)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public CommentResponse postNewComment(CommentRequest request) {
//        Comment comment = Comment.builder()
//                .username(request.getUsername())
//                .comment(request.getComment())
//                .post(request.getPost())
//                .build();

        Comment comment = new Comment();
        comment.setUsername(request.getUsername());
        comment.setComment(request.getComment());
        comment.setPost(request.getPost());

        return toResponse(commentRepository.save(comment));
    }

    private CommentResponse toResponse(Comment comment) {
        return CommentResponse.builder()
                .id(comment.getId())
                .username(comment.getUsername())
                .comment(comment.getComment())
                .post(comment.getPost())
                .createdAt(comment.getCreatedAt())
                .deleted(comment.getDeleted())
                .build();
    }
}
