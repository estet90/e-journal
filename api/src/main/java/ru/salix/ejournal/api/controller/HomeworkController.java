package ru.salix.ejournal.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.salix.ejournal.api.controller.handler.HomeworkControllerHandler;
import ru.salix.ejournal.api.model.api.HomeworkDto;
import ru.salix.ejournal.api.model.api.filter.HomeworkFilterDto;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static ru.salix.ejournal.api.error.operation.ModuleOperationCode.*;
import static ru.salix.ejournal.api.helper.ControllerWrapper.fillOperationName;

@RestController
@RequestMapping("/homework")
@RequiredArgsConstructor
public class HomeworkController {

    private final HomeworkControllerHandler handler;

    @GetMapping
    public ResponseEntity<List<HomeworkDto>> findHomework() {
        return fillOperationName(() -> ResponseEntity.ok(handler.findHomework()), HOMEWORK_MARKS_FIND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HomeworkDto> findHomework(
            @PathVariable("id") Long id
    ) {
        return fillOperationName(() -> ResponseEntity.ok(handler.findHomeworkById(id)), HOMEWORK_MARKS_FIND_BY_ID);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<HomeworkDto>> filter(
            @RequestParam(name = "id", required = false) Long id,
            @RequestParam(name = "dateReceiveFrom", required = false) LocalDate dateReceiveFrom,
            @RequestParam(name = "dateReceiveTo", required = false) LocalDate dateReceiveTo,
            @RequestParam(name = "dateCompleteFrom", required = false) LocalDate dateCompleteFrom,
            @RequestParam(name = "dateCompleteTo", required = false) LocalDate dateCompleteTo,
            @RequestParam(name = "subject", required = false) String subject,
            @RequestParam(name = "className", required = false) String className,
            @RequestParam(name = "teacherName", required = false) String teacherName,
            @RequestParam(name = "teacherSurname", required = false) String teacherSurname,
            @RequestParam(name = "teacherPatronymic", required = false) String teacherPatronymic,
            @RequestParam(name = "pupilName", required = false) String pupilName,
            @RequestParam(name = "pupilSurname", required = false) String pupilSurname,
            @RequestParam(name = "pupilPatronymic", required = false) String pupilPatronymic
    ) {
        var filter = HomeworkFilterDto.builder()
                .id(id)
                .dateReceiveFrom(dateReceiveFrom)
                .dateReceiveTo(dateReceiveTo)
                .dateCompleteFrom(dateCompleteFrom)
                .dateCompleteTo(dateCompleteTo)
                .subject(subject)
                .className(className)
                .teacherName(teacherName)
                .teacherSurname(teacherSurname)
                .teacherPatronymic(teacherPatronymic)
                .pupilName(pupilName)
                .pupilSurname(pupilSurname)
                .pupilPatronymic(pupilPatronymic)
                .build();
        return fillOperationName(() -> ResponseEntity.ok(handler.filter(filter)), HOMEWORK_MARKS_FILTER);
    }

    @PostMapping
    public ResponseEntity<Long> createHomework(
            @RequestBody HomeworkDto homeworkDto
    ) {
        return fillOperationName(() -> ResponseEntity.status(CREATED).body(handler.createHomework(homeworkDto)), HOMEWORK_MARKS_CREATE);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateHomework(
            @RequestBody HomeworkDto homeworkDto,
            @PathVariable("id") Long id
    ) {
        return fillOperationName(() -> ResponseEntity.accepted().body(handler.updateHomework(homeworkDto, id)), HOMEWORK_MARKS_CREATE);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteHomework(
            @PathVariable("id") Long id
    ) {
        return fillOperationName(() -> ResponseEntity.accepted().body(handler.deleteHomework(id)), HOMEWORK_MARKS_DELETE);
    }

}
