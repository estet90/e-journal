package ru.salix.ejournal.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.salix.ejournal.api.controller.handler.SchoolClassControllerHandler;
import ru.salix.ejournal.api.model.api.SchoolClassDto;
import ru.salix.ejournal.api.model.api.filter.SchoolClassFilterDto;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static ru.salix.ejournal.api.error.operation.ModuleOperationCode.*;
import static ru.salix.ejournal.api.helper.ControllerWrapper.fillOperationName;

@RestController
@RequestMapping("/classes")
@RequiredArgsConstructor
public class SchoolClassController {

    private final SchoolClassControllerHandler handler;

    @GetMapping
    public ResponseEntity<List<SchoolClassDto>> findClasses() {
        return fillOperationName(() -> ResponseEntity.ok(handler.findClasses()), CLASSES_FIND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchoolClassDto> findClassesById(
            @PathVariable("id") Long id
    ) {
        return fillOperationName(() -> ResponseEntity.ok(handler.findClassById(id)), CLASSES_FIND_BY_ID);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<SchoolClassDto>> filter(
            @RequestParam(name = "id", required = false) Long id,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "teacherName", required = false) String teacherName,
            @RequestParam(name = "teacherSurname", required = false) String teacherSurname,
            @RequestParam(name = "teacherPatronymic", required = false) String teacherPatronymic,
            @RequestParam(name = "pupilName", required = false) String pupilName,
            @RequestParam(name = "pupilSurname", required = false) String pupilSurname,
            @RequestParam(name = "pupilPatronymic", required = false) String pupilPatronymic,
            @RequestParam(name = "subject", required = false) String subject
    ) {
        return fillOperationName(() -> {
            var filter = SchoolClassFilterDto.builder()
                    .id(id)
                    .name(name)
                    .teacherName(teacherName)
                    .teacherSurname(teacherSurname)
                    .teacherPatronymic(teacherPatronymic)
                    .pupilName(pupilName)
                    .pupilSurname(pupilSurname)
                    .pupilPatronymic(pupilPatronymic)
                    .subject(subject)
                    .build();
            return ResponseEntity.ok(handler.filter(filter));
        }, CLASSES_FILTER);
    }

    @PostMapping
    public ResponseEntity<Long> createClass(
            @RequestBody SchoolClassDto schoolClass
    ) {
        return fillOperationName(() -> ResponseEntity.status(CREATED).body(handler.createClass(schoolClass)), CLASSES_CREATE);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateClass(
            @RequestBody SchoolClassDto schoolClass,
            @PathVariable("id") Long id
    ) {
        return fillOperationName(() -> ResponseEntity.accepted().body(handler.updateClass(schoolClass, id)), CLASSES_UPDATE);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteClass(
            @PathVariable("id") Long id
    ) {
        return fillOperationName(() -> ResponseEntity.accepted().body(handler.deleteClass(id)), CLASSES_DELETE);
    }

    @PostMapping("/{idClass}/pupils/{idPupil}")
    public ResponseEntity<Long> addPupilToClass(
            @PathVariable("idClass") Long idClass,
            @PathVariable("idPupil") Long idPupil
    ) {
        return fillOperationName(() -> ResponseEntity.accepted().body(handler.addPupilToClass(idClass, idPupil)), CLASSES_PUPILS_ADD);
    }

    @DeleteMapping("/{idClass}/pupils/{idPupil}")
    public ResponseEntity<Long> deletePupilFromClass(
            @PathVariable("idClass") Long idClass,
            @PathVariable("idPupil") Long idPupil
    ) {
        return fillOperationName(() -> ResponseEntity.accepted().body(handler.deletePupilFromClass(idClass, idPupil)), CLASSES_PUPILS_DELETE);
    }

}
