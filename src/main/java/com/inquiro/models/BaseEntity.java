package com.inquiro.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity {

    @Id
    private String id;

    @CreatedDate
    @Field("createdAt")
    private LocalDateTime createdAt = LocalDateTime.now();;

    @LastModifiedDate
    @Field("updatedAt")
    private LocalDateTime updatedAt = LocalDateTime.now();;
}
