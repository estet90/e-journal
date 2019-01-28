package ru.salix.ejournal.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.salix.ejournal.api.model.api.SubjectDto;
import ru.salix.ejournal.api.model.api.filter.SubjectFilterDto;
import ru.salix.ejournal.api.controller.handler.SubjectControllerHandler;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static ru.salix.ejournal.api.error.operation.ModuleOperationCode.*;
import static ru.salix.ejournal.api.helper.ControllerWrapper.fillOperationName;

@RestController
@RequestMapping("/subjects")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectControllerHandler handler;

    @GetMapping
    public ResponseEntity<List<SubjectDto>> findSubjects() {
        return fillOperationName(() -> ResponseEntity.ok(handler.findSubjects()), SUBJECTS_FIND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectDto> subjectById(
            @PathVariable("id") Long id
    ) {
        return fillOperationName(() -> ResponseEntity.ok(handler.findSubjectById(id)), SUBJECTS_FIND_BY_ID);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<SubjectDto>> filter(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "teacherName", required = false) String teacherName,
            @RequestParam(value = "teacherSurname", required = false) String teacherSurname,
            @RequestParam(value = "teacherPatronymic", required = false) String teacherPatronymic,
            @RequestParam(value = "className", required = false) String className
    ) {
        var filter = SubjectFilterDto.builder()
                .id(id)
                .name(name)
                .teacherName(teacherName)
                .teacherSurname(teacherSurname)
                .teacherPatronymic(teacherPatronymic)
                .className(className)
                .build();
        return fillOperationName(() -> ResponseEntity.ok(handler.filter(filter)), SUBJECTS_FILTER);
    }

    @PostMapping
    public ResponseEntity<Long> createSubject(
            @RequestBody SubjectDto subjectDto
    ) {
        return fillOperationName(() -> new ResponseEntity<>(handler.createSubject(subjectDto), CREATED), SUBJECTS_CREATE);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateSubject(
            @PathVariable(value = "id") Long id,
            @RequestBody SubjectDto subjectDto
    ) {
        return fillOperationName(() -> ResponseEntity.accepted().body(handler.updateSubject(subjectDto, id)), SUBJECTS_UPDATE);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteSubject(
            @PathVariable(value = "id") Long id
    ) {
        return fillOperationName(() -> ResponseEntity.accepted().body(handler.deleteSubject(id)), SUBJECTS_DELETE);
    }

}
