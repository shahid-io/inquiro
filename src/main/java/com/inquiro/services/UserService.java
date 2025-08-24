package com.inquiro.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.inquiro.models.User;
import com.inquiro.repositories.UserRepository;
import com.inquiro.security.JwtUtil;
import com.inquiro.services.impl.IUserService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Mono<User> signup(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        User newUser = User.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .password(encodedPassword)
                .fullName(user.getFullName())
                .bio(user.getBio())
                .profile(user.getProfile())
                .build();
        return userRepository.save(newUser);
    }

    public Mono<String> signin(String username, String password) {
        return userRepository.findByUsername(username)
                .flatMap(user -> {
                    if (passwordEncoder.matches(password, user.getPassword())) {
                        return Mono.just(jwtUtil.generateToken(username));
                    } else {
                        return Mono.error(new RuntimeException("Invalid credentials"));
                    }
                })
                .switchIfEmpty(Mono.error(new RuntimeException("User not found")));
    }

    public Mono<User> findByUsername(String username) {
        // Implementation here
        return null;
    }

}
