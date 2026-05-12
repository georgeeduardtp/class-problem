package com.aula.classproblem.classroom.service;

import com.aula.classproblem.classroom.dto.DeviceDto;
import java.util.List;

public interface DeviceService {
    List<DeviceDto> findAll();
    DeviceDto findById(Long id);
    DeviceDto create(DeviceDto dto);
    DeviceDto update(Long id, DeviceDto dto);
    void delete(Long id);
    List<DeviceDto> findByClassroom(Long classroomId);
}
