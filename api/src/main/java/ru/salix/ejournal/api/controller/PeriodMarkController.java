package ru.salix.ejournal.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.salix.ejournal.api.controller.handler.PeriodMarkControllerHandler;
import ru.salix.ejournal.api.model.api.PeriodMarkDto;
import ru.salix.ejournal.api.model.api.filter.PeriodMarkFilterDto;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static ru.salix.ejournal.api.error.operation.ModuleOperationCode.*;
import static ru.salix.ejournal.api.helper.ControllerWrapper.fillOperationName;

@RestController
@RequestMapping("/period-marks")
@RequiredArgsConstructor
public class PeriodMarkController {

    private final PeriodMarkControllerHandler handler;

    @GetMapping
    public ResponseEntity<List<PeriodMarkDto>> findPeriodMarks() {
        return fillOperationName(() -> ResponseEntity.ok(handler.findPeriodMarks()), EXAM_MARKS_FIND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeriodMarkDto> findPeriodMarkById(
            @PathVariable("id") Long id
    ) {
        return fillOperationName(() -> ResponseEntity.ok(handler.findPeriodMarkById(id)), EXAM_MARKS_FIND_BY_ID);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<PeriodMarkDto>> filter(
            @RequestParam(name = "id", required = false) Long id,
            @RequestParam(name = "dateFrom", required = false) LocalDate dateFrom,
            @RequestParam(name = "dateTo", required = false) LocalDate dateTo,
            @RequestParam(name = "subject", required = false) String subject,
            @RequestParam(name = "className", required = false) String className,
            @RequestParam(name = "teacherName", required = false) String teacherName,
            @RequestParam(name = "teacherSurname", required = false) String teacherSurname,
            @RequestParam(name = "teacherPatronymic", required = false) String teacherPatronymic
    ) {
        var filter = PeriodMarkFilterDto.builder()
                .id(id)
                .dateFrom(dateFrom)
                .dateTo(dateTo)
                .subject(subject)
                .className(className)
                .teacherName(teacherName)
                .teacherSurname(teacherSurname)
                .teacherPatronymic(teacherPatronymic)
                .build();
        return fillOperationName(() -> ResponseEntity.ok(handler.filter(filter)), EXAM_MARKS_FILTER);
    }

    @PostMapping
    public ResponseEntity<Long> createPeriodMark(
            @RequestBody PeriodMarkDto periodMark
    ) {
        return fillOperationName(() -> new ResponseEntity<>(handler.createPeriodMark(periodMark), CREATED), EXAM_MARKS_CREATE);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updatePeriodMark(
            @RequestBody PeriodMarkDto periodMark,
            @PathVariable("id") Long id
    ) {
        return fillOperationName(() -> ResponseEntity.accepted().body(handler.updatePeriodMark(periodMark, id)), EXAM_MARKS_UPDATE);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deletePeriodMark(
            @PathVariable("id") Long id
    ) {
        return fillOperationName(() -> ResponseEntity.accepted().body(handler.deletePeriodMark(id)), EXAM_MARKS_DELETE);
    }

}
