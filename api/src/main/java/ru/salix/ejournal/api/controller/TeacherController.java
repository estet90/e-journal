package ru.salix.ejournal.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.salix.ejournal.api.controller.dto.SchoolClassDto;
import ru.salix.ejournal.api.controller.dto.SubjectDto;
import ru.salix.ejournal.api.controller.dto.TeacherDto;
import ru.salix.ejournal.api.controller.dto.TeacherFilterDto;
import ru.salix.ejournal.api.controller.handler.TeacherControllerHandler;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static ru.salix.ejournal.api.error.operation.ModuleOperationCode.*;
import static ru.salix.ejournal.api.helper.ControllerWrapper.fillOperationName;

@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherControllerHandler handler;

    @GetMapping
    public ResponseEntity<List<TeacherDto>> findTeachers() {
        return fillOperationName(() -> ResponseEntity.ok(handler.findTeachers()), TEACHERS_FIND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDto> findTeacherById(
            @PathVariable("id") long id
    ) {
        return fillOperationName(() -> ResponseEntity.ok(handler.findTeacherById(id)), TEACHERS_FIND_BY_ID);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<TeacherDto>> filter(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "surname", required = false) String surname,
            @RequestParam(value = "patronymic", required = false) String patronymic,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "subject", required = false) String subject,
            @RequestParam(value = "relatedClassName", required = false) String relatedClassName,
            @RequestParam(value = "ownClassName", required = false) String ownClassName
    ) {
        var filter = TeacherFilterDto.builder()
                .id(id)
                .name(name)
                .surname(surname)
                .subject(subject)
                .patronymic(patronymic)
                .description(description)
                .relatedClassName(relatedClassName)
                .ownClassName(ownClassName)
                .build();
        return fillOperationName(() -> ResponseEntity.ok(handler.filter(filter)), TEACHERS_FILTER);
    }

    @PostMapping
    public ResponseEntity<Long> createTeacher(
            @RequestBody TeacherDto teacherDto
    ) {
        return fillOperationName(() -> new ResponseEntity<>(handler.createTeacher(teacherDto), CREATED), TEACHERS_CREATE);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateTeacher(
            @PathVariable(value = "id") Long id,
            @RequestBody TeacherDto teacherDto
    ) {
        return fillOperationName(() -> ResponseEntity.accepted().body(handler.updateTeacher(teacherDto, id)), TEACHERS_UPDATE);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteTeacher(
            @PathVariable(value = "id") Long id
    ) {
        return fillOperationName(() -> ResponseEntity.accepted().body(handler.deleteTeacher(id)), TEACHERS_DELETE);
    }

    @GetMapping("/{id}/subjects")
    public ResponseEntity<List<SubjectDto>> findSubjectsByTeacherId(
            @PathVariable(value = "id") Long id
    ) {
        return fillOperationName(() -> ResponseEntity.ok(handler.subjectsByTeacherId(id)), TEACHERS_SUBJECTS_FIND);
    }

    @PostMapping("/{idTeacher}/subjects/{idSubject}")
    public ResponseEntity<Long> addSubjectToTeacher(
            @PathVariable(value = "idTeacher") Long idTeacher,
            @PathVariable(value = "idSubject") Long idSubject
    ) {
        return fillOperationName(() -> ResponseEntity.accepted().body(handler.addSubjectToTeacher(idTeacher, idSubject)), TEACHERS_SUBJECTS_FIND);
    }

    @DeleteMapping("/{idTeacher}/subjects/{idSubject}")
    public ResponseEntity<Long> deleteSubjectFromTeacher(
            @PathVariable(value = "idTeacher") Long idTeacher,
            @PathVariable(value = "idSubject") Long idSubject
    ) {
        return fillOperationName(() -> ResponseEntity.accepted().body(handler.deleteSubjectFromTeacher(idTeacher, idSubject)), TEACHERS_SUBJECTS_FIND);
    }

    @GetMapping("/{id}/classes")
    public ResponseEntity<List<SchoolClassDto>> findClassesByTeacherId(
            @PathVariable(value = "id") Long id
    ) {
        return fillOperationName(() -> ResponseEntity.ok(handler.classesByTeacherId(id)), TEACHERS_CLASSES);
    }

}
