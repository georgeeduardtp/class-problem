package com.aula.classproblem.classroom.dto;

import java.time.OffsetDateTime;

public class ClassroomDto {
    private Long id;
    private String module;
    private String number;
    private OffsetDateTime createdAt;

    private String health;
    private Long activeIncidentsCount;

    public ClassroomDto() {
    }

    public ClassroomDto(Long id, String module, String number, OffsetDateTime createdAt) {
        this.id = id;
        this.module = module;
        this.number = number;
        this.createdAt = createdAt;
    }

    public ClassroomDto(Long id, String module, String number, OffsetDateTime createdAt, String health, Long activeIncidentsCount) {
        this.id = id;
        this.module = module;
        this.number = number;
        this.createdAt = createdAt;
        this.health = health;
        this.activeIncidentsCount = activeIncidentsCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public Long getActiveIncidentsCount() {
        return activeIncidentsCount;
    }

    public void setActiveIncidentsCount(Long activeIncidentsCount) {
        this.activeIncidentsCount = activeIncidentsCount;
    }
}
