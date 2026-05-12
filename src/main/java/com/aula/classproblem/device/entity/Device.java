package com.aula.classproblem.device.entity;

import com.aula.classproblem.classroom.entity.Classroom;

import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "device")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Builder.Default
    @Column(name = "serial", unique = true)
    private String serial = UUID.randomUUID().toString().substring(0, 8).toUpperCase();

    @Column(name = "display_name", nullable = false)
    private String displayName;

    @Column(name = "device_type")
    private String deviceType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    @Builder.Default
    @Column(name = "created_at", nullable = false, updatable = false)
    private OffsetDateTime createdAt = OffsetDateTime.now();

}
