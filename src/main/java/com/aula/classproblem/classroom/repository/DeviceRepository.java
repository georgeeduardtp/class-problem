package com.aula.classproblem.classroom.repository;

import com.aula.classproblem.classroom.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    List<Device> findByClassroomId(Long classroomId);
    boolean existsBySerial(String serial);
}
