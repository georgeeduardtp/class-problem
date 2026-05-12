package com.aula.classproblem.incidence.mapper;

import com.aula.classproblem.incidence.dto.IncidenceDto;
import com.aula.classproblem.incidence.entity.Incidence;

public final class IncidenceMapper {

    private IncidenceMapper() {
    }

    public static IncidenceDto toDto(Incidence entity) {
        if (entity == null) {
            return null;
        }
        return new IncidenceDto(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getStatus(),
                entity.getUserId(),
                entity.getClassroomId(),
                entity.getDeviceId(),
                entity.getPhotoUrl(),
                entity.getReportedAt(),
                entity.getResolvedAt()
        );
    }

    public static Incidence toEntity(IncidenceDto dto) {
        if (dto == null) {
            return null;
        }
        Incidence entity = new Incidence();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        if (dto.getStatus() != null) {
            entity.setStatus(dto.getStatus());
        }
        entity.setUserId(dto.getUserId());
        entity.setClassroomId(dto.getClassroomId());
        entity.setDeviceId(dto.getDeviceId());
        entity.setPhotoUrl(dto.getPhotoUrl());
        entity.setReportedAt(dto.getReportedAt());
        entity.setResolvedAt(dto.getResolvedAt());
        return entity;
    }
}
