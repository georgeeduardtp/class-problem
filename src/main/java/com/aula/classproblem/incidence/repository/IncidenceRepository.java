package com.aula.classproblem.incidence.repository;

import com.aula.classproblem.incidence.entity.Incidence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidenceRepository extends JpaRepository<Incidence, Long> {

}
