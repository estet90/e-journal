package ru.salix.ejournal.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.salix.ejournal.api.controller.handler.TimetableControllerHandler;
import ru.salix.ejournal.api.model.api.TimetableDto;
import ru.salix.ejournal.api.model.api.filter.TimetableFilterDto;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static ru.salix.ejournal.api.error.operation.ModuleOperationCode.*;
import static ru.salix.ejournal.api.helper.ControllerWrapper.fillOperationName;

@RestController
@RequestMapping("/timetables")
@RequiredArgsConstructor
public class TimetableController {

    private final TimetableControllerHandler handler;

    @GetMapping
    public ResponseEntity<List<TimetableDto>> findTimetables() {
        return fillOperationName(() -> ResponseEntity.ok(handler.findTimetables()), TIMETABLES_FIND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimetableDto> findTimetableById(
            @PathVariable("id") Long id
    ) {
        return fillOperationName(() -> ResponseEntity.ok(handler.findTimetableById(id)), TIMETABLES_FIND_BY_ID);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<TimetableDto>> filter(
            @RequestParam(name = "id", required = false) Long id,
            @RequestParam(name = "teacherName", required = false) String teacherName,
            @RequestParam(name = "teacherSurname", required = false) String teacherSurname,
            @RequestParam(name = "teacherPatronymic", required = false) String teacherPatronymic,
            @RequestParam(name = "pupilName", required = false) String pupilName,
            @RequestParam(name = "pupilSurname", required = false) String pupilSurname,
            @RequestParam(name = "pupilPatronymic", required = false) String pupilPatronymic,
            @RequestParam(name = "subject", required = false) String subject,
            @RequestParam(name = "className", required = false) String className,
            @RequestParam(name = "lessonPeriodNumber", required = false) Integer lessonPeriodNumber,
            @RequestParam(name = "lessonPeriodShift", required = false) Integer lessonPeriodShift
    ) {
        var filter = TimetableFilterDto.builder()
                .id(id)
                .teacherName(teacherName)
                .teacherSurname(teacherSurname)
                .teacherPatronymic(teacherPatronymic)
                .pupilName(pupilName)
                .pupilSurname(pupilSurname)
                .pupilPatronymic(pupilPatronymic)
                .subject(subject)
                .className(className)
                .lessonPeriodNumber(lessonPeriodNumber)
                .lessonPeriodShift(lessonPeriodShift)
                .build();
        return fillOperationName(() -> ResponseEntity.ok(handler.filter(filter)), TIMETABLES_FILTER);
    }

    @PostMapping
    public ResponseEntity<Long> createTimetable(
            @RequestBody TimetableDto timetableDto
    ) {
        return fillOperationName(() -> new ResponseEntity<>(handler.createTimetable(timetableDto), CREATED), TIMETABLES_CREATE);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateTimetable(
            @PathVariable(value = "id") Long id,
            @RequestBody TimetableDto timetableDto
    ) {
        return fillOperationName(() -> ResponseEntity.accepted().body(handler.updateTimetable(timetableDto, id)), TIMETABLES_UPDATE);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteTimetable(
            @PathVariable(value = "id") Long id
    ) {
        return fillOperationName(() -> ResponseEntity.accepted().body(handler.deleteTimetable(id)), TIMETABLES_DELETE);
    }
}
