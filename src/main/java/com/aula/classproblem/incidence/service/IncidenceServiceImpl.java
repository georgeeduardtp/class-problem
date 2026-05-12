package com.aula.classproblem.incidence.service;

import com.aula.classproblem.incidence.dto.IncidenceDto;
import com.aula.classproblem.incidence.entity.Incidence;
import com.aula.classproblem.incidence.entity.IncidentStatus;
import com.aula.classproblem.incidence.mapper.IncidenceMapper;
import com.aula.classproblem.incidence.repository.IncidenceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class IncidenceServiceImpl implements IncidenceService {

    private final IncidenceRepository repository;
    private final IncidenceHistoryService historyService;

    public IncidenceServiceImpl(IncidenceRepository repository, IncidenceHistoryService historyService) {
        this.repository = repository;
        this.historyService = historyService;
    }

    @Override
    public List<IncidenceDto> findAll() {
        return repository.findAll().stream().map(IncidenceMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public IncidenceDto findById(Long id) {
        return repository.findById(id).map(IncidenceMapper::toDto).orElse(null);
    }

    @Override
    public IncidenceDto create(IncidenceDto dto) {
        Incidence entity = IncidenceMapper.toEntity(dto);
        if (entity.getReportedAt() == null) {
            entity.setReportedAt(java.time.OffsetDateTime.now());
        }
        Incidence saved = repository.save(entity);

        historyService.recordHistory(
                saved.getId(),
                saved.getUserId(),
                null,
                saved.getStatus(),
                "Incidencia creada"
        );

        return IncidenceMapper.toDto(saved);
    }

    @Override
    public IncidenceDto update(Long id, IncidenceDto dto) {
        return repository.findById(id).map(existing -> {
            IncidentStatus oldStatus = existing.getStatus();
            
            existing.setTitle(dto.getTitle());
            existing.setDescription(dto.getDescription());
            if (dto.getStatus() != null) {
                existing.setStatus(dto.getStatus());
            }
            if (dto.getUserId() != null) {
                existing.setUserId(dto.getUserId());
            }
            existing.setClassroomId(dto.getClassroomId());
            existing.setDeviceId(dto.getDeviceId());
            existing.setPhotoUrl(dto.getPhotoUrl());
            if (dto.getResolvedAt() != null) {
                existing.setResolvedAt(dto.getResolvedAt());
            }
            
            Incidence saved = repository.save(existing);

            if (oldStatus != saved.getStatus()) {
                historyService.recordHistory(
                        saved.getId(),
                        dto.getUserId(),
                        oldStatus,
                        saved.getStatus(),
                        "Estado actualizado"
                );
            }

            return IncidenceMapper.toDto(saved);
        }).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
