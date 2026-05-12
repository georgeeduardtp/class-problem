package com.aula.classproblem.incidence.service;

import com.aula.classproblem.incidence.dto.IncidenceHistoryDto;
import com.aula.classproblem.incidence.entity.IncidentStatus;

import java.util.List;

public interface IncidenceHistoryService {
    List<IncidenceHistoryDto> findByIncidenceId(Long incidenceId);
    void recordHistory(Long incidenceId, Long changedBy, IncidentStatus fromStatus, IncidentStatus toStatus, String note);
}
