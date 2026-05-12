package com.aula.classproblem.incidence.repository;

import com.aula.classproblem.incidence.entity.IncidenceHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncidenceHistoryRepository extends JpaRepository<IncidenceHistory, Long> {
    List<IncidenceHistory> findByIncidenceIdOrderByCreatedAtDesc(Long incidenceId);
}
