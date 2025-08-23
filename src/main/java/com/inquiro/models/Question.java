package com.inquiro.models;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import jakarta.validation.constraints.NotBlank;


import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    private String id;

    @NotBlank(message = "Title is required")
    private String title;

}
