package com.aula.classproblem.user.dto;

import com.aula.classproblem.user.entity.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record AppUserInput(
    @NotBlank @Size(max = 100) String username,
    @Size(max = 200) String fullName,
    @Email @Size(max = 200) String email,
    @NotNull UserRole roles
) {}
