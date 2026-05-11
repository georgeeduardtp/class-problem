package com.aula.classproblem.user.dto;

import java.time.OffsetDateTime;

import com.aula.classproblem.user.entity.UserRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppUserOutput {

    private Long id;
    private String username;
    private String fullName;
    private String email;
    private UserRole roles;
    private OffsetDateTime createdAt;
}
