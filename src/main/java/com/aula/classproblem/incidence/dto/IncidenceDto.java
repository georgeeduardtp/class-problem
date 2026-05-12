package com.aula.classproblem.incidence.dto;

import java.time.OffsetDateTime;
import com.aula.classproblem.incidence.entity.IncidentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IncidenceDto {
    private Long id;
    private String title;
    private String description;
    private IncidentStatus status;
    private Long userId;
    private Long classroomId;
    private Long deviceId;
    private String photoUrl;
    private OffsetDateTime reportedAt;
    private OffsetDateTime resolvedAt;
}