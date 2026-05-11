package com.aula.classproblem.classroom.dto;

import lombok.*;
import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeviceDto {
    private Long id;
    private String serial;
    private String displayName;
    private String deviceType;
    private Long classroomId;
    private OffsetDateTime createdAt;
}
