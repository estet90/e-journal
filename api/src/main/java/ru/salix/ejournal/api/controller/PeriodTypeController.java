package ru.salix.ejournal.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.salix.ejournal.api.controller.handler.PeriodTypeControllerHandler;
import ru.salix.ejournal.api.model.api.PeriodTypeDto;
import ru.salix.ejournal.api.model.api.filter.PeriodTypeFilterDto;

import java.util.List;

import static ru.salix.ejournal.api.error.operation.ModuleOperationCode.*;
import static ru.salix.ejournal.api.helper.ControllerWrapper.fillOperationName;

@RestController
@RequestMapping("/period-types")
@RequiredArgsConstructor
public class PeriodTypeController {

    private final PeriodTypeControllerHandler handler;

    @GetMapping
    public ResponseEntity<List<PeriodTypeDto>> findPeriodTypes() {
        return fillOperationName(() -> ResponseEntity.ok(handler.findPeriodTypes()), PERIOD_TYPES_FIND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeriodTypeDto> findPeriodTypeById(
            @PathVariable("id") Long id
    ) {
        return fillOperationName(() -> ResponseEntity.ok(handler.findPeriodTypeById(id)), PERIOD_TYPES_FIND_BY_ID);
    }

    public ResponseEntity<List<PeriodTypeDto>> filter(
            @RequestParam(name = "id", required = false) Long id,
            @RequestParam(name = "name", required = false) String name
    ) {
        var filter = PeriodTypeFilterDto.builder()
                .id(id)
                .name(name)
                .build();
        return fillOperationName(() -> ResponseEntity.ok(handler.filter(filter)), PERIOD_TYPES_FILTER);
    }

}
