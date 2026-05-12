package com.aula.classproblem.incidence.dto;

import com.aula.classproblem.incidence.entity.IncidentStatus;
import java.time.OffsetDateTime;

public class IncidenceHistoryDto {

    private Long id;
    private Long incidenceId;
    private Long changedBy;
    private IncidentStatus fromStatus;
    private IncidentStatus toStatus;
    private String note;
    private OffsetDateTime createdAt;

    public IncidenceHistoryDto() {
    }

    public IncidenceHistoryDto(Long id, Long incidenceId, Long changedBy, IncidentStatus fromStatus, IncidentStatus toStatus, String note, OffsetDateTime createdAt) {
        this.id = id;
        this.incidenceId = incidenceId;
        this.changedBy = changedBy;
        this.fromStatus = fromStatus;
        this.toStatus = toStatus;
        this.note = note;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getIncidenceId() { return incidenceId; }
    public void setIncidenceId(Long incidenceId) { this.incidenceId = incidenceId; }

    public Long getChangedBy() { return changedBy; }
    public void setChangedBy(Long changedBy) { this.changedBy = changedBy; }

    public IncidentStatus getFromStatus() { return fromStatus; }
    public void setFromStatus(IncidentStatus fromStatus) { this.fromStatus = fromStatus; }

    public IncidentStatus getToStatus() { return toStatus; }
    public void setToStatus(IncidentStatus toStatus) { this.toStatus = toStatus; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    public OffsetDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(OffsetDateTime createdAt) { this.createdAt = createdAt; }
}
