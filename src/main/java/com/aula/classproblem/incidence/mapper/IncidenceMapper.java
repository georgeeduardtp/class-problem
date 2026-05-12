package com.aula.classproblem.incidence.mapper;

import org.springframework.stereotype.Component;
import com.aula.classproblem.incidence.dto.IncidenceDto;
import com.aula.classproblem.incidence.entity.Incidence;

@Component
public class IncidenceMapper {

    public Incidence toEntity(IncidenceDto dto) {
        if (dto == null)
            return null;
        return Incidence.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .status(dto.getStatus())
                .userId(dto.getUserId())
                .classroomId(dto.getClassroomId())
                .deviceId(dto.getDeviceId())
                .photoUrl(dto.getPhotoUrl())
                .reportedAt(dto.getReportedAt())
                .resolvedAt(dto.getResolvedAt())
                .build();
    }

    public IncidenceDto toDto(Incidence entity) {
        if (entity == null)
            return null;
        return IncidenceDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .status(entity.getStatus())
                .userId(entity.getUserId())
                .classroomId(entity.getClassroomId())
                .deviceId(entity.getDeviceId())
                .photoUrl(entity.getPhotoUrl())
                .reportedAt(entity.getReportedAt())
                .resolvedAt(entity.getResolvedAt())
                .build();
    }
}