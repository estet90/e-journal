package ru.salix.ejournal.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.salix.ejournal.api.controller.handler.PeriodControllerHandler;
import ru.salix.ejournal.api.model.api.PeriodDto;
import ru.salix.ejournal.api.model.api.filter.PeriodFilterDto;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static ru.salix.ejournal.api.error.operation.ModuleOperationCode.*;
import static ru.salix.ejournal.api.helper.ControllerWrapper.fillOperationName;

@RestController
@RequestMapping("/periods")
@RequiredArgsConstructor
public class PeriodController {

    private final PeriodControllerHandler handler;

    @GetMapping
    public ResponseEntity<List<PeriodDto>> findPeriods() {
        return fillOperationName(() -> ResponseEntity.ok(handler.findPeriods()), PERIODS_FIND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeriodDto> findPeriodById(
            @PathVariable("id") Long id
    ) {
        return fillOperationName(() -> ResponseEntity.ok(handler.findPeriodById(id)), PERIODS_FIND_BY_ID);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<PeriodDto>> filter(
            @RequestParam(name = "id", required = false) Long id,
            @RequestParam(name = "periodType", required = false) String periodType,
            @RequestParam(name = "dateStartFrom", required = false) LocalDate dateStartFrom,
            @RequestParam(name = "dateStartTo", required = false) LocalDate dateStartTo,
            @RequestParam(name = "dateEndFrom", required = false) LocalDate dateEndFrom,
            @RequestParam(name = "dateEndTo", required = false) LocalDate dateEndTo
    ) {
        var filter = PeriodFilterDto.builder()
                .id(id)
                .periodType(periodType)
                .dateStartFrom(dateStartFrom)
                .dateStartTo(dateStartTo)
                .dateEndFrom(dateEndFrom)
                .dateEndTo(dateEndTo)
                .build();
        return fillOperationName(() -> ResponseEntity.ok(handler.filter(filter)), PERIODS_FILTER);
    }

    @PostMapping
    public ResponseEntity<Long> createPeriod(
            @RequestBody PeriodDto periodDto
    ) {
        return fillOperationName(() -> ResponseEntity.status(CREATED).body(handler.createPeriod(periodDto)), PERIODS_CREATE);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updatePeriod(
            @RequestBody PeriodDto periodDto,
            @PathVariable("id") Long id
    ) {
        return fillOperationName(() -> ResponseEntity.accepted().body(handler.updatePeriod(periodDto, id)), PERIODS_UPDATE);
    }

}
