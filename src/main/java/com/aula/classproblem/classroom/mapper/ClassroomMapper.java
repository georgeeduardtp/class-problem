package com.aula.classproblem.classroom.mapper;

import com.aula.classproblem.classroom.dto.ClassroomDto;
import com.aula.classproblem.classroom.entity.Classroom;

public final class ClassroomMapper {

    private ClassroomMapper() {
    }

    public static ClassroomDto toDto(Classroom c) {
        if (c == null)
            return null;
        return new ClassroomDto(c.getId(), c.getModule(), c.getNumber(), c.getCreatedAt());
    }

    public static Classroom toEntity(ClassroomDto d) {
        if (d == null)
            return null;
        Classroom c = new Classroom();
        c.setId(d.getId());
        c.setModule(d.getModule());
        c.setNumber(d.getNumber());
        c.setCreatedAt(d.getCreatedAt());
        return c;
    }
}
