package com.aula.classproblem.classroom.service;

import com.aula.classproblem.classroom.dto.ClassroomDto;
import com.aula.classproblem.classroom.entity.Classroom;
import com.aula.classproblem.classroom.repository.ClassroomRepository;
import com.aula.classproblem.classroom.mapper.ClassroomMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClassroomServiceImpl implements ClassroomService {

    private final ClassroomRepository repository;

    public ClassroomServiceImpl(ClassroomRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ClassroomDto> findAll() {
        return repository.findAll().stream().map(ClassroomMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ClassroomDto findById(Long id) {
        return repository.findById(id).map(ClassroomMapper::toDto).orElse(null);
    }

    @Override
    public ClassroomDto create(ClassroomDto dto) {
        Classroom entity = ClassroomMapper.toEntity(dto);
        if (entity.getCreatedAt() == null)
            entity.setCreatedAt(java.time.OffsetDateTime.now());
        Classroom saved = repository.save(entity);
        return ClassroomMapper.toDto(saved);
    }

    @Override
    public ClassroomDto update(Long id, ClassroomDto dto) {
        return repository.findById(id).map(existing -> {
            existing.setModule(dto.getModule());
            existing.setNumber(dto.getNumber());
            Classroom saved = repository.save(existing);
            return ClassroomMapper.toDto(saved);
        }).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
