package com.aula.classproblem.classroom.entity;

import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "classroom")
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "module", nullable = false)
    private String module;

    @Column(name = "number")
    private String number;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    public Classroom() {
        this.createdAt = OffsetDateTime.now();
    }

    public Classroom(Long id, String module, String number, OffsetDateTime createdAt) {
        this.id = id;
        this.module = module;
        this.number = number;
        this.createdAt = createdAt == null ? OffsetDateTime.now() : createdAt;
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
}
