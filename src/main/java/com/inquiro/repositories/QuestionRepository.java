package com.inquiro.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.inquiro.models.Question;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Repository for Question documents.
 */
@Repository
public interface QuestionRepository extends ReactiveMongoRepository<Question, String> {

    /**
     * Finds all questions by author id.
     *
     * @param id the author id
     * @return a Flux of questions
     */
    Flux<Question> findByAuthor(String id);

    /**
     * Counts the number of questions by author id.
     *
     * @param id the author id
     * @return a Mono of the count
     */
    Mono<Long> countByAuthor(String id);
}
