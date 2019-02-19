package ru.salix.ejournal.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.salix.ejournal.api.controller.handler.LessonMarkControllerHandler;
import ru.salix.ejournal.api.model.api.LessonMarkDto;
import ru.salix.ejournal.api.model.api.filter.LessonMarkFilterDto;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static ru.salix.ejournal.api.error.operation.ModuleOperationCode.*;
import static ru.salix.ejournal.api.helper.ControllerWrapper.fillOperationName;

@RestController("/lesson-marks")
@RequiredArgsConstructor
public class LessonMarkController {

    private final LessonMarkControllerHandler handler;

    @GetMapping
    public ResponseEntity<List<LessonMarkDto>> findLessonMarks() {
        return fillOperationName(() -> ResponseEntity.ok(handler.findLessonMarks()), LESSON_MARKS_FIND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LessonMarkDto> findLessonMarkById(
            @PathVariable("id") Long id
    ) {
        return fillOperationName(() -> ResponseEntity.ok(handler.findLessonMarkById(id)), LESSON_MARKS_FIND_BY_ID);
    }

    public ResponseEntity<List<LessonMarkDto>> filter(
            @RequestParam(name = "id", required = false) Long id,
            @RequestParam(name = "datetimeFrom", required = false) LocalDateTime datetimeFrom,
            @RequestParam(name = "datetimeTo", required = false) LocalDateTime datetimeTo,
            @RequestParam(name = "subject", required = false) String subject,
            @RequestParam(name = "className", required = false) String className,
            @RequestParam(name = "teacherName", required = false) String teacherName,
            @RequestParam(name = "teacherSurname", required = false) String teacherSurname,
            @RequestParam(name = "teacherPatronymic", required = false) String teacherPatronymic,
            @RequestParam(name = "lessonMark", defaultValue = "false") Boolean lessonMark,
            @RequestParam(name = "testMark", defaultValue = "false") Boolean testMark,
            @RequestParam(name = "homeworkMark", defaultValue = "false") Boolean homeworkMark
    ) {
        var filter = LessonMarkFilterDto.builder()
                .id(id)
                .datetimeFrom(datetimeFrom)
                .datetimeTo(datetimeTo)
                .subject(subject)
                .className(className)
                .teacherName(teacherName)
                .teacherSurname(teacherSurname)
                .teacherPatronymic(teacherPatronymic)
                .lessonMark(lessonMark)
                .testMark(testMark)
                .homeworkMark(homeworkMark)
                .build();
        return fillOperationName(() -> ResponseEntity.ok(handler.filter(filter)), LESSON_MARKS_FILTER);
    }

    @PostMapping
    public ResponseEntity<Long> createLessonMark(
            @RequestBody LessonMarkDto lessonMark
    ) {
        return fillOperationName(() -> new ResponseEntity<>(handler.createLessonMark(lessonMark), CREATED), LESSON_MARKS_CREATE);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateLessonMark(
            @RequestBody LessonMarkDto lessonMark,
            @PathVariable("id") Long id
    ) {
        return fillOperationName(() -> ResponseEntity.accepted().body(handler.updateLessonMark(lessonMark, id)), LESSON_MARKS_UPDATE);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteLessonMark(
            @PathVariable("id") Long id
    ) {
        return fillOperationName(() -> ResponseEntity.accepted().body(handler.deleteLessonMark(id)), LESSON_MARKS_DELETE);
    }

}
