package com.aula.classproblem.incidence.dto;

import java.time.OffsetDateTime;
import com.aula.classproblem.incidence.entity.IncidentStatus;

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

    public IncidenceDto() {
    }

    public IncidenceDto(Long id, String title, String description, IncidentStatus status, Long userId, Long classroomId, Long deviceId, String photoUrl, OffsetDateTime reportedAt, OffsetDateTime resolvedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.userId = userId;
        this.classroomId = classroomId;
        this.deviceId = deviceId;
        this.photoUrl = photoUrl;
        this.reportedAt = reportedAt;
        this.resolvedAt = resolvedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public IncidentStatus getStatus() {
        return status;
    }

    public void setStatus(IncidentStatus status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Long classroomId) {
        this.classroomId = classroomId;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public OffsetDateTime getReportedAt() {
        return reportedAt;
    }

    public void setReportedAt(OffsetDateTime reportedAt) {
        this.reportedAt = reportedAt;
    }

    public OffsetDateTime getResolvedAt() {
        return resolvedAt;
    }

    public void setResolvedAt(OffsetDateTime resolvedAt) {
        this.resolvedAt = resolvedAt;
    }
}
