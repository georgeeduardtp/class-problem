package com.aula.classproblem.incidence.repository;

import com.aula.classproblem.incidence.entity.Incidence;
import com.aula.classproblem.incidence.entity.IncidentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncidenceRepository extends JpaRepository<Incidence, Long> {
    long countByClassroomIdAndStatusIn(Long classroomId, List<IncidentStatus> statuses);
}
