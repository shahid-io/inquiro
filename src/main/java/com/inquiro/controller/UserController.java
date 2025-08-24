package com.inquiro.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.inquiro.dto.request.AuthRequestDTO;
import com.inquiro.dto.request.UserRequestDTO;
import com.inquiro.dto.response.AuthResponseDTO;
import com.inquiro.dto.response.UserResponseDTO;
import com.inquiro.models.User;
import com.inquiro.services.impl.IUserService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final IUserService userService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<UserResponseDTO> signup(@RequestBody UserRequestDTO userRequestDTO) {
        User user = User.builder()
                .username(userRequestDTO.getUsername())
                .email(userRequestDTO.getEmail())
                .password(userRequestDTO.getPassword())
                .fullName(userRequestDTO.getFullName())
                .bio(userRequestDTO.getBio())
                .profile(userRequestDTO.getProfile())
                .build();
        return userService.signup(user)
                .map(savedUser -> UserResponseDTO.builder()
                        .id(savedUser.getId())
                        .username(savedUser.getUsername())
                        .email(savedUser.getEmail())
                        .fullName(savedUser.getFullName())
                        .bio(savedUser.getBio())
                        .profile(savedUser.getProfile())
                        .createdAt(savedUser.getCreatedAt().toString())
                        .updatedAt(savedUser.getUpdatedAt().toString())
                        .build());
    }

    @PostMapping("/signin")
    public Mono<AuthResponseDTO> signin(@RequestBody AuthRequestDTO authRequestDTO) {
        return userService.signin(authRequestDTO.getUsername(), authRequestDTO.getPassword())
                .map(token -> AuthResponseDTO.builder()
                        .token(token)
                        .username(authRequestDTO.getUsername())
                        .build());
    }

}
