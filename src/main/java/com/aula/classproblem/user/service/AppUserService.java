package com.aula.classproblem.user.service;

import java.util.List;

import com.aula.classproblem.user.dto.AppUserInput;
import com.aula.classproblem.user.dto.AppUserOutput;

public interface AppUserService {
    List<AppUserOutput> findAll();

    AppUserOutput findById(Long id);

    AppUserOutput create(AppUserInput input);

    AppUserOutput update(Long id, AppUserInput input);

    void delete(Long id);
}
