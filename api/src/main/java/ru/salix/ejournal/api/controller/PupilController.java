package ru.salix.ejournal.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.salix.ejournal.api.model.api.PupilDto;
import ru.salix.ejournal.api.model.api.filter.PupilFilterDto;
import ru.salix.ejournal.api.controller.handler.PupilControllerHandler;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static ru.salix.ejournal.api.error.operation.ModuleOperationCode.*;
import static ru.salix.ejournal.api.helper.ControllerWrapper.fillOperationName;

@RestController
@RequestMapping("/pupils")
@RequiredArgsConstructor
public class PupilController {

    private final PupilControllerHandler handler;

    @GetMapping
    public ResponseEntity<List<PupilDto>> findPupils() {
        return fillOperationName(() -> ResponseEntity.ok(handler.findPupils()), PUPILS_FIND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PupilDto> findPupilById(
            @PathVariable("id") Long id
    ) {
        return fillOperationName(() -> ResponseEntity.ok(handler.findPupilById(id)), PUPILS_FIND);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<PupilDto>> filter(
            @RequestParam(name = "id", required = false) Long id,
            @RequestParam(name = "className", required = false) String className,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "surname", required = false) String surname,
            @RequestParam(name = "patronymic", required = false) String patronymic,
            @RequestParam(name = "description", required = false) String description
    ) {
        var filter = PupilFilterDto.builder()
                .id(id)
                .name(name)
                .surname(surname)
                .patronymic(patronymic)
                .className(className)
                .description(description)
                .build();
        return fillOperationName(() -> ResponseEntity.ok(handler.filter(filter)), PUPILS_FILTER);
    }

    @PostMapping
    public ResponseEntity<Long> createPupil(
            @RequestBody PupilDto pupilDto
    ) {
        return fillOperationName(() -> new ResponseEntity<>(handler.createPupil(pupilDto), CREATED), PUPILS_CREATE);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updatePupil(
            @PathVariable(value = "id") Long id,
            @RequestBody PupilDto pupilDto
    ) {
        return fillOperationName(() -> ResponseEntity.accepted().body(handler.updatePupil(pupilDto, id)), PUPILS_UPDATE);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deletePupil(
            @PathVariable(value = "id") Long id
    ) {
        return fillOperationName(() -> ResponseEntity.accepted().body(handler.deletePupil(id)), PUPILS_DELETE);
    }

}
