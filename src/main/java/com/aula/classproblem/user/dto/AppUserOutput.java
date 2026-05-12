package com.aula.classproblem.user.dto;

import java.time.OffsetDateTime;

import com.aula.classproblem.user.entity.UserRole;

import lombok.Builder;

@Builder
public record AppUserOutput(
    Long id,
    String username,
    String fullName,
    String email,
    UserRole roles,
    OffsetDateTime createdAt
) {}
