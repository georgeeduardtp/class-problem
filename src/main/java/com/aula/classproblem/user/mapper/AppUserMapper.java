package com.aula.classproblem.user.mapper;

import com.aula.classproblem.user.dto.AppUserInput;
import com.aula.classproblem.user.dto.AppUserOutput;
import com.aula.classproblem.user.entity.AppUser;

public final class AppUserMapper {

    private AppUserMapper() {
    }

    public static AppUserOutput toOutput(AppUser user) {
        if (user == null) {
            return null;
        }
        return AppUserOutput.builder()
                .id(user.getId())
                .username(user.getUsername())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .roles(user.getRoles())
                .createdAt(user.getCreatedAt())
                .build();
    }

    public static AppUser toEntity(AppUserInput input) {
        if (input == null) {
            return null;
        }
        return AppUser.builder()
                .username(input.getUsername())
                .fullName(input.getFullName())
                .email(input.getEmail())
                .roles(input.getRoles())
                .build();
    }
}
