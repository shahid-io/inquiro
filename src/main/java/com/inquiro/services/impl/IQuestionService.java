package com.inquiro.services.impl;

import com.inquiro.dto.QuestionRequestDTO;
import com.inquiro.dto.QuestionResponseDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IQuestionService {
    public Mono<QuestionResponseDTO> createQuestion(QuestionRequestDTO questionRequestDTO);
    public Mono<QuestionResponseDTO> getQuestionById(String id);
    public Flux<QuestionResponseDTO> getAllQuestions();
}
