package com.aula.classproblem.user.dto;

import com.aula.classproblem.user.entity.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppUserInput {

    @NotBlank
    @Size(max = 100)
    private String username;

    @Size(max = 200)
    private String fullName;

    @Email
    @Size(max = 200)
    private String email;

    @NotNull
    private UserRole roles;
}
