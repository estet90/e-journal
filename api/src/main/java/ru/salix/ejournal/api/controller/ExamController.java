package ru.salix.ejournal.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.salix.ejournal.api.model.api.ExamDto;
import ru.salix.ejournal.api.model.api.filter.ExamFilterDto;
import ru.salix.ejournal.api.controller.handler.ExamControllerHandler;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static ru.salix.ejournal.api.error.operation.ModuleOperationCode.*;
import static ru.salix.ejournal.api.helper.ControllerWrapper.fillOperationName;

@RestController
@RequestMapping("/exams")
@RequiredArgsConstructor
public class ExamController {

    private final ExamControllerHandler handler;

    @GetMapping
    public ResponseEntity<List<ExamDto>> findExams() {
        return fillOperationName(() -> ResponseEntity.ok(handler.findExams()), EXAMS_FIND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamDto> findExamById(
            @PathVariable("id") Long id
    ) {
        return fillOperationName(() -> ResponseEntity.ok(handler.findExamById(id)), EXAMS_FIND_BY_ID);
    }

    public ResponseEntity<List<ExamDto>> filter(
            @RequestParam(name = "id", required = false) Long id,
            @RequestParam(name = "datetimeFrom", required = false) LocalDateTime datetimeFrom,
            @RequestParam(name = "datetimeTo", required = false) LocalDateTime datetimeTo,
            @RequestParam(name = "subject", required = false) String subject,
            @RequestParam(name = "className", required = false) String className,
            @RequestParam(name = "teacherName", required = false) String teacherName,
            @RequestParam(name = "teacherSurname", required = false) String teacherSurname,
            @RequestParam(name = "teacherPatronymic", required = false) String teacherPatronymic
    ) {
        var filter = ExamFilterDto.builder()
                .id(id)
                .datetimeFrom(datetimeFrom)
                .datetimeTo(datetimeTo)
                .subject(subject)
                .className(className)
                .teacherName(teacherName)
                .teacherSurname(teacherSurname)
                .teacherPatronymic(teacherPatronymic)
                .build();
        return fillOperationName(() -> ResponseEntity.ok(handler.filter(filter)), EXAMS_FILTER);
    }

    @PostMapping
    public ResponseEntity<Long> createExam(
            @RequestBody ExamDto exam
    ) {
        return fillOperationName(() -> new ResponseEntity<>(handler.createExam(exam), CREATED), EXAMS_CREATE);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateExam(
            @RequestBody ExamDto exam,
            @PathVariable("id") Long id
    ) {
        return fillOperationName(() -> ResponseEntity.accepted().body(handler.updateExam(exam, id)), EXAMS_UPDATE);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteExam(
            @PathVariable("id") Long id
    ) {
        return fillOperationName(() -> ResponseEntity.accepted().body(handler.deleteExam(id)), EXAMS_DELETE);
    }

}
