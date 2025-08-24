package com.inquiro.mapper;

import com.inquiro.dto.QuestionResponseDTO;
import com.inquiro.models.Question;

public class QuestionMapper {

    public static QuestionResponseDTO toQuestionResponseDTO(Question question) {
        return QuestionResponseDTO.builder()
                .id(question.getId())
                .title(question.getTitle())
                .content(question.getContent())
                .authorId(question.getAuthorId())
                .status(question.getStatus().name())
                .createdAt(question.getCreatedAt())
                .updatedAt(question.getUpdatedAt())
                .build();
    }
}
