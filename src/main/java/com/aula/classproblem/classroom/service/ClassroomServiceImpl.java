package com.aula.classproblem.classroom.service;

import com.aula.classproblem.classroom.dto.ClassroomDto;
import com.aula.classproblem.classroom.entity.Classroom;
import com.aula.classproblem.classroom.repository.ClassroomRepository;
import com.aula.classproblem.classroom.mapper.ClassroomMapper;
import com.aula.classproblem.incidence.entity.IncidentStatus;
import com.aula.classproblem.incidence.repository.IncidenceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClassroomServiceImpl implements ClassroomService {

    private final ClassroomRepository repository;
    private final IncidenceRepository incidenceRepository;
    private static final List<IncidentStatus> ACTIVE_STATUSES = List.of(IncidentStatus.OPEN, IncidentStatus.IN_PROGRESS);

    public ClassroomServiceImpl(ClassroomRepository repository, IncidenceRepository incidenceRepository) {
        this.repository = repository;
        this.incidenceRepository = incidenceRepository;
    }

    @Override
    public List<ClassroomDto> findAll() {
        return repository.findAll().stream()
                .map(this::mapToDtoWithHealth)
                .collect(Collectors.toList());
    }

    @Override
    public ClassroomDto findById(Long id) {
        return repository.findById(id)
                .map(this::mapToDtoWithHealth)
                .orElse(null);
    }

    private ClassroomDto mapToDtoWithHealth(Classroom classroom) {
        ClassroomDto dto = ClassroomMapper.toDto(classroom);
        long count = incidenceRepository.countByClassroomIdAndStatusIn(classroom.getId(), ACTIVE_STATUSES);
        dto.setActiveIncidentsCount(count);
        
        if (count == 0) {
            dto.setHealth("GREEN");
        } else if (count <= 2) {
            dto.setHealth("YELLOW");
        } else {
            dto.setHealth("RED");
        }
        
        return dto;
    }

    @Override
    public ClassroomDto create(ClassroomDto dto) {
        Classroom entity = ClassroomMapper.toEntity(dto);
        if (entity.getCreatedAt() == null)
            entity.setCreatedAt(java.time.OffsetDateTime.now());
        Classroom saved = repository.save(entity);
        return mapToDtoWithHealth(saved);
    }

    @Override
    public ClassroomDto update(Long id, ClassroomDto dto) {
        return repository.findById(id).map(existing -> {
            existing.setModule(dto.getModule());
            existing.setNumber(dto.getNumber());
            Classroom saved = repository.save(existing);
            return mapToDtoWithHealth(saved);
        }).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
