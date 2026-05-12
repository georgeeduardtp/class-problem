package com.aula.classproblem.classroom.mapper;

import com.aula.classproblem.classroom.dto.DeviceDto;
import com.aula.classproblem.classroom.entity.Classroom;
import com.aula.classproblem.classroom.entity.Device;

public final class DeviceMapper {

    private DeviceMapper() {
    }

    public static DeviceDto toDto(Device entity) {
        if (entity == null) {
            return null;
        }

        return DeviceDto.builder()
                .id(entity.getId())
                .serial(entity.getSerial())
                .displayName(entity.getDisplayName())
                .deviceType(entity.getDeviceType())
                .classroomId(entity.getClassroom() != null ? entity.getClassroom().getId() : null)
                .createdAt(entity.getCreatedAt())
                .build();
    }

    public static Device toEntity(DeviceDto dto) {
        if (dto == null) {
            return null;
        }

        Device entity = new Device();
        entity.setId(dto.getId());
        entity.setSerial(dto.getSerial());
        entity.setDisplayName(dto.getDisplayName());
        entity.setDeviceType(dto.getDeviceType());
        entity.setCreatedAt(dto.getCreatedAt());

        if (dto.getClassroomId() != null) {
            Classroom classroom = new Classroom();
            classroom.setId(dto.getClassroomId());
            entity.setClassroom(classroom);
        }

        return entity;
    }
}
