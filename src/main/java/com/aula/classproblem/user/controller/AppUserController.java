package com.aula.classproblem.user.controller;

import java.util.List;

import com.aula.classproblem.user.dto.AppUserInput;
import com.aula.classproblem.user.dto.AppUserOutput;
import com.aula.classproblem.user.service.AppUserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class AppUserController {

    private final AppUserService service;

    @GetMapping
    public List<AppUserOutput> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public AppUserOutput get(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AppUserOutput create(@Valid @RequestBody AppUserInput input) {
        return service.create(input);
    }

    @PutMapping("/{id}")
    public AppUserOutput update(@PathVariable Long id, @Valid @RequestBody AppUserInput input) {
        return service.update(id, input);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
