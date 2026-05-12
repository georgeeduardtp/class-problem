package com.aula.classproblem.incidence.controller;

import com.aula.classproblem.incidence.dto.IncidenceHistoryDto;
import com.aula.classproblem.incidence.service.IncidenceHistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/incidences/{incidenceId}/history")
public class IncidenceHistoryController {

    private final IncidenceHistoryService historyService;

    public IncidenceHistoryController(IncidenceHistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping
    public ResponseEntity<List<IncidenceHistoryDto>> getHistory(@PathVariable Long incidenceId) {
        List<IncidenceHistoryDto> history = historyService.findByIncidenceId(incidenceId);
        return ResponseEntity.ok(history);
    }
}
