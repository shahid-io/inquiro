package com.inquiro.services.impl;

import com.inquiro.models.User;

import reactor.core.publisher.Mono;

public interface IUserService {
    Mono<User> signup(User user);

    Mono<String> signin(String username, String password);

    Mono<User> findByUsername(String username);
}
