package com.aula.classproblem.classroom.repository;

import com.aula.classproblem.classroom.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {

}
