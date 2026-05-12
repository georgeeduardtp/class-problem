package com.aula.classproblem.incidence.mapper;

import com.aula.classproblem.incidence.dto.IncidenceHistoryDto;
import com.aula.classproblem.incidence.entity.IncidenceHistory;

public final class IncidenceHistoryMapper {

    private IncidenceHistoryMapper() {}

    public static IncidenceHistoryDto toDto(IncidenceHistory entity) {
        if (entity == null) {
            return null;
        }
        return new IncidenceHistoryDto(
                entity.getId(),
                entity.getIncidenceId(),
                entity.getChangedBy(),
                entity.getFromStatus(),
                entity.getToStatus(),
                entity.getNote(),
                entity.getCreatedAt()
        );
    }

    public static IncidenceHistory toEntity(IncidenceHistoryDto dto) {
        if (dto == null) {
            return null;
        }
        return IncidenceHistory.builder()
                .id(dto.getId())
                .incidenceId(dto.getIncidenceId())
                .changedBy(dto.getChangedBy())
                .fromStatus(dto.getFromStatus())
                .toStatus(dto.getToStatus())
                .note(dto.getNote())
                .createdAt(dto.getCreatedAt() != null ? dto.getCreatedAt() : java.time.OffsetDateTime.now())
                .build();
    }
}
