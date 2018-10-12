package ru.salix.ejournal.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.salix.ejournal.api.controllers.dto.TeacherDto;
import ru.salix.ejournal.api.controllers.dto.TeacherFilterDto;
import ru.salix.ejournal.api.controllers.handlers.TeacherControllerHandler;

import java.util.List;

@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherControllerHandler teacherControllerHandler;

    @GetMapping
    public List<TeacherDto> teachers(
            @RequestParam(value = "withSubjects", defaultValue = "false") boolean withSubjects,
            @RequestParam(value = "withClasses", defaultValue = "false") boolean withClasses
    ) {
        return teacherControllerHandler.teachers(withSubjects, withClasses);
    }

    @GetMapping("/{id}")
    public TeacherDto teacherById(
            @PathVariable("id") long id,
            @RequestParam(value = "withSubjects", defaultValue = "false") boolean withSubjects,
            @RequestParam(value = "withClasses", defaultValue = "false") boolean withClasses
    ) {
        return teacherControllerHandler.teacherById(id, withSubjects, withClasses);
    }

    @PostMapping("/filter")
    public List<TeacherDto> teachersFilter(
            @RequestParam(value = "withSubjects", defaultValue = "false") boolean withSubjects,
            @RequestParam(value = "withClasses", defaultValue = "false") boolean withClasses,
            @RequestBody TeacherFilterDto filter
    ) {
        return teacherControllerHandler.filter(filter, withSubjects, withClasses);
    }

}
