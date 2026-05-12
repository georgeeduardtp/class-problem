package com.aula.classproblem.incidence.service;

import com.aula.classproblem.incidence.dto.IncidenceDto;
import java.util.List;

public interface IncidenceService {
    List<IncidenceDto> findAll();

    IncidenceDto findById(Long id);

    IncidenceDto create(IncidenceDto dto);

    IncidenceDto update(Long id, IncidenceDto dto);

    void delete(Long id);
}
