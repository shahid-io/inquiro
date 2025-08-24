package com.inquiro.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {

    private String id;
    private String username;
    private String email;
    private String fullName;
    private String bio;
    private String profile;
    private String createdAt;
    private String updatedAt;
}
