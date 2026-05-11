package com.aula.classproblem.classroom.service;

import com.aula.classproblem.classroom.dto.ClassroomDto;
import java.util.List;

public interface ClassroomService {
    List<ClassroomDto> findAll();

    ClassroomDto findById(Long id);

    ClassroomDto create(ClassroomDto dto);

    ClassroomDto update(Long id, ClassroomDto dto);

    void delete(Long id);
}
