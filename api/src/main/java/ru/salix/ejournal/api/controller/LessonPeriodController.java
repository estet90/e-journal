package ru.salix.ejournal.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.salix.ejournal.api.controller.handler.LessonPeriodControllerHandler;
import ru.salix.ejournal.api.error.operation.ModuleOperationCode;
import ru.salix.ejournal.api.model.api.LessonPeriodDto;
import ru.salix.ejournal.api.model.api.filter.LessonPeriodFilterDto;

import java.time.LocalTime;
import java.util.List;

import static ru.salix.ejournal.api.helper.ControllerWrapper.fillOperationName;

@RestController
@RequestMapping("/lesson-periods")
@RequiredArgsConstructor
public class LessonPeriodController {

    private final LessonPeriodControllerHandler handler;

    @GetMapping
    public ResponseEntity<List<LessonPeriodDto>> findLessonPeriods() {
        return fillOperationName(() -> ResponseEntity.ok(handler.findLessonPeriods()), ModuleOperationCode.LESSON_PERIODS_FIND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LessonPeriodDto> findLessonPeriodById(
            @PathVariable("id") Long id
    ) {
        return fillOperationName(() -> ResponseEntity.ok(handler.findLessonPeriodById(id)), ModuleOperationCode.LESSON_PERIODS_FIND_BY_ID);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<LessonPeriodDto>> filter(
            @RequestParam(name = "id", required = false) Long id,
            @RequestParam(name = "shift", required = false) Integer shift,
            @RequestParam(name = "number", required = false) Integer number,
            @RequestParam(name = "timeStartFrom", required = false) LocalTime timeStartFrom,
            @RequestParam(name = "timeStartTo", required = false) LocalTime timeStartTo,
            @RequestParam(name = "timeEndFrom", required = false) LocalTime timeEndFrom,
            @RequestParam(name = "timeEndTo", required = false) LocalTime timeEndTo
    ) {
        var filter = LessonPeriodFilterDto.builder()
                .id(id)
                .shift(shift)
                .number(number)
                .timeStartFrom(timeStartFrom)
                .timeStartTo(timeStartTo)
                .timeEndFrom(timeEndFrom)
                .timeEndTo(timeEndTo)
                .build();
        return fillOperationName(() -> ResponseEntity.ok(handler.filter(filter)), ModuleOperationCode.LESSON_PERIODS_FILTER);
    }

}
