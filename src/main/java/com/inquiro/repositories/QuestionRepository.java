package com.inquiro.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.inquiro.models.Question;

@Repository
public interface QuestionRepository extends ReactiveMongoRepository<Question, String> {
}
