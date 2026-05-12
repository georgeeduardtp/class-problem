package com.aula.classproblem.incidence.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.aula.classproblem.incidence.dto.IncidenceDto;
import com.aula.classproblem.incidence.entity.Incidence;
import com.aula.classproblem.incidence.mapper.IncidenceMapper;
import com.aula.classproblem.incidence.repository.IncidenceRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IncidenceServiceImpl implements IncidenceService {

    private final IncidenceRepository repository;
    private final IncidenceMapper mapper;

    @Override
    public List<IncidenceDto> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public IncidenceDto findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElse(null);
    }

    @Override
    public IncidenceDto create(IncidenceDto dto) {
        Incidence entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public IncidenceDto update(Long id, IncidenceDto dto) {
        if (!repository.existsById(id))
            return null;
        Incidence entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}