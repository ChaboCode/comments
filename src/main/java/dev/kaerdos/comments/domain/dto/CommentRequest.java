package dev.kaerdos.comments.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequest {

    @NotBlank(message = "El usuario es obligatorio")
    private String username;

    @NotBlank(message = "El comentario es obligatorio")
    private String comment;

    @NotBlank(message = "El comentario tiene que referenciar un post")
    private String post;
}
