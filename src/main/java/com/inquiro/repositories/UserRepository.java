package com.inquiro.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.inquiro.models.User;

import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveMongoRepository<User, String> {
    Mono<User> findByUsername(String username);

    Mono<User> findByEmail(String email);

    Mono<Boolean> existsByUsername(String username);

    Mono<Boolean> existsByEmail(String email);

}
