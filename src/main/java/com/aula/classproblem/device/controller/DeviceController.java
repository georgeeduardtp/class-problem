package com.aula.classproblem.classroom.controller;

import com.aula.classproblem.classroom.dto.DeviceDto;
import com.aula.classproblem.classroom.service.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
@RequiredArgsConstructor
public class DeviceController {

    private final DeviceService service;

    @GetMapping
    public List<DeviceDto> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviceDto> get(@PathVariable Long id) {
        DeviceDto dto = service.findById(id);
        return dto == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(dto);
    }

    @GetMapping("/classroom/{classroomId}")
    public List<DeviceDto> listByClassroom(@PathVariable Long classroomId) {
        return service.findByClassroom(classroomId);
    }

    @PostMapping
    public ResponseEntity<DeviceDto> create(@RequestBody DeviceDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeviceDto> update(@PathVariable Long id, @RequestBody DeviceDto dto) {
        DeviceDto updated = service.update(id, dto);
        return updated == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
