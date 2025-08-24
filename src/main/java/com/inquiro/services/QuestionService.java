package com.inquiro.services;

import org.springframework.stereotype.Service;

import com.inquiro.models.Question;
import com.inquiro.repositories.QuestionRepository;
import com.inquiro.dto.QuestionRequestDTO;
import com.inquiro.dto.QuestionResponseDTO;
import com.inquiro.mapper.QuestionMapper;
import com.inquiro.services.impl.IQuestionService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class QuestionService implements IQuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public Mono<QuestionResponseDTO> createQuestion(QuestionRequestDTO questionRequestDTO) {
        Question question = Question.builder()
                .title(questionRequestDTO.getTitle())
                .content(questionRequestDTO.getContent())
                .authorId(questionRequestDTO.getAuthorId())
                .build();

        return questionRepository.save(question)
                .map(QuestionMapper::toQuestionResponseDTO);
        // return questionRepository.save(question)
        // .map(QuestionMapper::toQuestionResponseDTO)
        // .doOnSuccess(response -> System.out.println("Question Created Successfully: "
        // + response))
        // .doOnError(error -> System.out.println("Error Creating Question: " +
        // error.getMessage()));
    }

    @Override
    public Mono<QuestionResponseDTO> getQuestionById(String id) {
        return questionRepository.findById(id)
                .map(QuestionMapper::toQuestionResponseDTO);
    }

    // @Override
    // public Flux<QuestionResponseDTO> getAllQuestions() {
    // return questionRepository.findAll()
    // .map(QuestionMapper::toQuestionResponseDTO);
    // }

    @Override
    public Flux<QuestionResponseDTO> getAllQuestions(int page, int size, String search, String authorId) {
        Flux<Question> flux;

        if (search != null && !search.isEmpty()) {
            flux = questionRepository.findByTitleContainingIgnoreCase(search);
        } else if (authorId != null && !authorId.isEmpty()) {
            flux = questionRepository.findByAuthorId(authorId);
        } else {
            flux = questionRepository.findAll();
        }

        return flux
                .skip((long) page * size)
                .take(size)
                .map(QuestionMapper::toQuestionResponseDTO);
    }

}
