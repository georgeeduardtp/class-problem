package com.aula.classproblem.classroom.controller;

import com.aula.classproblem.classroom.dto.ClassroomDto;
import com.aula.classproblem.classroom.service.ClassroomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/classrooms")
public class ClassroomController {

    private final ClassroomService service;

    public ClassroomController(ClassroomService service) {
        this.service = service;
    }

    @GetMapping
    public List<ClassroomDto> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassroomDto> get(@PathVariable Long id) {
        ClassroomDto dto = service.findById(id);
        return dto == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ClassroomDto> create(@RequestBody ClassroomDto dto) {
        ClassroomDto created = service.create(dto);
        return ResponseEntity.created(URI.create("/api/classrooms/" + created.getId())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassroomDto> update(@PathVariable Long id, @RequestBody ClassroomDto dto) {
        ClassroomDto updated = service.update(id, dto);
        return updated == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
