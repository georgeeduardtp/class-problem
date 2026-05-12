package com.aula.classproblem.device.service;

import com.aula.classproblem.classroom.entity.Classroom;
import com.aula.classproblem.classroom.repository.ClassroomRepository;
import com.aula.classproblem.device.dto.DeviceDto;
import com.aula.classproblem.device.entity.Device;
import com.aula.classproblem.device.mapper.DeviceMapper;
import com.aula.classproblem.device.repository.DeviceRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository repository;
    private final ClassroomRepository classroomRepository;

    @Override
    @Transactional(readOnly = true)
    public List<DeviceDto> findAll() {
        return repository.findAll().stream()
                .map(DeviceMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public DeviceDto findById(Long id) {
        return repository.findById(id)
                .map(DeviceMapper::toDto)
                .orElse(null);
    }

    @Override
    public DeviceDto create(DeviceDto dto) {
        Device entity = DeviceMapper.toEntity(dto);

        if (dto.getClassroomId() != null) {
            Classroom classroom = classroomRepository.findById(dto.getClassroomId())
                    .orElseThrow(() -> new RuntimeException("Classroom not found"));
            entity.setClassroom(classroom);
        }

        return DeviceMapper.toDto(repository.save(entity));
    }

    @Override
    public DeviceDto update(Long id, DeviceDto dto) {
        Device existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Device not found"));

        existing.setSerial(dto.getSerial());
        existing.setDisplayName(dto.getDisplayName());
        existing.setDeviceType(dto.getDeviceType());

        if (dto.getClassroomId() != null) {
            Classroom classroom = classroomRepository.findById(dto.getClassroomId())
                    .orElseThrow(() -> new RuntimeException("Classroom not found"));
            existing.setClassroom(classroom);
        } else {
            existing.setClassroom(null);
        }

        return DeviceMapper.toDto(repository.save(existing));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DeviceDto> findByClassroom(Long classroomId) {
        return repository.findByClassroomId(classroomId).stream()
                .map(DeviceMapper::toDto)
                .collect(Collectors.toList());
    }
}
