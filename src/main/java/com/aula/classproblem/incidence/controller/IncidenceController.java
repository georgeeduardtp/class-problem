package com.aula.classproblem.incidence.controller;

import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aula.classproblem.incidence.dto.IncidenceDto;
import com.aula.classproblem.incidence.service.IncidenceService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/incidences")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class IncidenceController {

    private final IncidenceService service;

    @GetMapping
    public List<IncidenceDto> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncidenceDto> get(@PathVariable Long id) {
        IncidenceDto dto = service.findById(id);
        return dto == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<IncidenceDto> create(@RequestBody IncidenceDto dto) {
        IncidenceDto created = service.create(dto);
        return ResponseEntity.created(URI.create("/api/incidences/" + created.getId())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IncidenceDto> update(@PathVariable Long id, @RequestBody IncidenceDto dto) {
        IncidenceDto updated = service.update(id, dto);
        return updated == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}