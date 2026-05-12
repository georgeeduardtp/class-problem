package com.aula.classproblem.incidence.service;

import com.aula.classproblem.incidence.dto.IncidenceHistoryDto;
import com.aula.classproblem.incidence.entity.IncidenceHistory;
import com.aula.classproblem.incidence.entity.IncidentStatus;
import com.aula.classproblem.incidence.mapper.IncidenceHistoryMapper;
import com.aula.classproblem.incidence.repository.IncidenceHistoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class IncidenceHistoryServiceImpl implements IncidenceHistoryService {

    private final IncidenceHistoryRepository historyRepository;

    public IncidenceHistoryServiceImpl(IncidenceHistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public List<IncidenceHistoryDto> findByIncidenceId(Long incidenceId) {
        return historyRepository.findByIncidenceIdOrderByCreatedAtDesc(incidenceId).stream()
                .map(IncidenceHistoryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void recordHistory(Long incidenceId, Long changedBy, IncidentStatus fromStatus, IncidentStatus toStatus, String note) {
        IncidenceHistory history = IncidenceHistory.builder()
                .incidenceId(incidenceId)
                .changedBy(changedBy)
                .fromStatus(fromStatus)
                .toStatus(toStatus)
                .note(note)
                .createdAt(OffsetDateTime.now())
                .build();
        historyRepository.save(history);
    }
}
