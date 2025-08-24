package com.inquiro.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResponseDTO {
    private String id;
    private String title;
    private String content;
    private String authorId;
    private String status; // from enum
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
