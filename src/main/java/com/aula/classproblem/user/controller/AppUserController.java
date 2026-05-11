package com.aula.classproblem.user.controller;

import java.net.URI;
import java.util.List;

import com.aula.classproblem.user.dto.AppUserInput;
import com.aula.classproblem.user.dto.AppUserOutput;
import com.aula.classproblem.user.service.AppUserService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class AppUserController {

    private final AppUserService service;

    public AppUserController(AppUserService service) {
        this.service = service;
    }

    @GetMapping
    public List<AppUserOutput> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUserOutput> get(@PathVariable Long id) {
        AppUserOutput output = service.findById(id);
        return output == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(output);
    }

    @PostMapping
    public ResponseEntity<AppUserOutput> create(@Valid @RequestBody AppUserInput input) {
        AppUserOutput created = service.create(input);
        return ResponseEntity.created(URI.create("/api/users/" + created.getId())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppUserOutput> update(@PathVariable Long id, @Valid @RequestBody AppUserInput input) {
        AppUserOutput updated = service.update(id, input);
        return updated == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
