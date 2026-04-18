package dev.kaerdos.comments.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentResponse {
    private Long id;
    private String username;
    private String comment;
    private String post;
    private LocalDateTime createdAt;
    private boolean deleted;
}
