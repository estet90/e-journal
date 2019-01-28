package ru.salix.ejournal.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.salix.ejournal.api.model.api.SchoolClassDto;
import ru.salix.ejournal.api.controller.handler.SchoolClassControllerHandler;

import java.util.List;

import static ru.salix.ejournal.api.error.operation.ModuleOperationCode.CLASSES_FIND;
import static ru.salix.ejournal.api.error.operation.ModuleOperationCode.CLASSES_FIND_BY_ID;
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

}
