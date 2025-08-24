package com.inquiro.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.inquiro.models.Question;

import reactor.core.publisher.Flux;

@Repository
public interface QuestionRepository extends ReactiveMongoRepository<Question, String> {
    Flux<Question> findByTitleContainingIgnoreCase(String title);

    Flux<Question> findByAuthorId(String authorId);

}
