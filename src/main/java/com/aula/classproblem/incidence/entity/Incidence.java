package com.aula.classproblem.incidence.entity;

import java.time.OffsetDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "incidence")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Incidence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private IncidentStatus status = IncidentStatus.OPEN;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "classroom_id")
    private Long classroomId;

    @Column(name = "device_id")
    private Long deviceId;

    @Column(name = "photo_url", columnDefinition = "TEXT")
    private String photoUrl;

    @Builder.Default
    private OffsetDateTime reportedAt = OffsetDateTime.now();

    private OffsetDateTime resolvedAt;
}