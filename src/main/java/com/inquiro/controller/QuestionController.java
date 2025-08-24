package com.inquiro.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inquiro.dto.QuestionRequestDTO;
import com.inquiro.dto.QuestionResponseDTO;
import com.inquiro.services.impl.IQuestionService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/api/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final IQuestionService questionService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<QuestionResponseDTO> createQuestion(@RequestBody QuestionRequestDTO questionRequestDTO) {
        return questionService.createQuestion(questionRequestDTO)
                .doOnSuccess(response -> System.out.println("Question Created Successfully: " + response))
                .doOnError(error -> System.out.println("Error Creating Question: " + error.getMessage()));
    }

    @GetMapping("/{id}")
    public Mono<QuestionResponseDTO> getQuestionById(@PathVariable String id) {
        return questionService.getQuestionById(id)
                .doOnSuccess(response -> System.out.println("Fetched Question Successfully: " + response))
                .doOnError(error -> System.out.println("Error Fetching Question: " + error.getMessage()));
    }

    @GetMapping
    public Flux<QuestionResponseDTO> getAllQuestions() {
        return questionService.getAllQuestions()
                .doOnComplete(() -> System.out.println("All questions retrieved successfully"))
                .doOnError(error -> System.out.println("Error Retrieving Questions: " + error.getMessage()));
    }

}
