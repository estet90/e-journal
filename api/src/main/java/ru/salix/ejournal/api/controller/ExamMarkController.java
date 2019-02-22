package ru.salix.ejournal.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.salix.ejournal.api.controller.handler.ExamMarkControllerHandler;
import ru.salix.ejournal.api.model.api.ExamMarkDto;
import ru.salix.ejournal.api.model.api.filter.ExamMarkFilterDto;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static ru.salix.ejournal.api.error.operation.ModuleOperationCode.*;
import static ru.salix.ejournal.api.helper.ControllerWrapper.fillOperationName;

@RestController
@RequestMapping("/exam-marks")
@RequiredArgsConstructor
public class ExamMarkController {

    private final ExamMarkControllerHandler handler;

    @GetMapping
    public ResponseEntity<List<ExamMarkDto>> findExamMarks() {
        return fillOperationName(() -> ResponseEntity.ok(handler.findExamMarks()), EXAM_MARKS_FIND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamMarkDto> findExamMarkById(
            @PathVariable("id") Long id
    ) {
        return fillOperationName(() -> ResponseEntity.ok(handler.findExamMarkById(id)), EXAM_MARKS_FIND_BY_ID);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<ExamMarkDto>> filter(
            @RequestParam(name = "id", required = false) Long id,
            @RequestParam(name = "datetimeFrom", required = false) LocalDateTime datetimeFrom,
            @RequestParam(name = "datetimeTo", required = false) LocalDateTime datetimeTo,
            @RequestParam(name = "subject", required = false) String subject,
            @RequestParam(name = "className", required = false) String className,
            @RequestParam(name = "teacherName", required = false) String teacherName,
            @RequestParam(name = "teacherSurname", required = false) String teacherSurname,
            @RequestParam(name = "teacherPatronymic", required = false) String teacherPatronymic,
            @RequestParam(name = "pupilName", required = false) String pupilName,
            @RequestParam(name = "pupilSurname", required = false) String pupilSurname,
            @RequestParam(name = "pupilPatronymic", required = false) String pupilPatronymic
    ) {
        var filter = ExamMarkFilterDto.builder()
                .id(id)
                .datetimeFrom(datetimeFrom)
                .datetimeTo(datetimeTo)
                .subject(subject)
                .className(className)
                .teacherName(teacherName)
                .teacherSurname(teacherSurname)
                .teacherPatronymic(teacherPatronymic)
                .pupilName(pupilName)
                .pupilSurname(pupilSurname)
                .pupilPatronymic(pupilPatronymic)
                .build();
        return fillOperationName(() -> ResponseEntity.ok(handler.filter(filter)), EXAM_MARKS_FILTER);
    }

    @PostMapping
    public ResponseEntity<Long> createExamMark(
            @RequestBody ExamMarkDto examMark
    ) {
        return fillOperationName(() -> new ResponseEntity<>(handler.createExamMark(examMark), CREATED), EXAM_MARKS_CREATE);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateExamMark(
            @RequestBody ExamMarkDto examMark,
            @PathVariable("id") Long id
    ) {
        return fillOperationName(() -> ResponseEntity.accepted().body(handler.updateExamMark(examMark, id)), EXAM_MARKS_UPDATE);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteExamMark(
            @PathVariable("id") Long id
    ) {
        return fillOperationName(() -> ResponseEntity.accepted().body(handler.deleteExamMark(id)), EXAM_MARKS_DELETE);
    }

}
