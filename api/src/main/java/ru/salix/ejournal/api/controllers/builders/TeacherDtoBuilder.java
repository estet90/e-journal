package ru.salix.ejournal.api.controllers.builders;

import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.controllers.dto.SchoolClassDto;
import ru.salix.ejournal.api.controllers.dto.SubjectDto;
import ru.salix.ejournal.api.controllers.dto.TeacherDto;
import ru.salix.ejournal.api.entities.Teacher;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;

@Component
public class TeacherDtoBuilder extends AbstractBuilder<TeacherDto, Teacher> {

    @Override
    public TeacherDto build(Teacher teacher) {
        return TeacherDto.builder()
                .id(teacher.getId())
                .name(teacher.getName())
                .surname(teacher.getSurname())
                .patronymic(teacher.getPatronymic())
                .description(teacher.getDescription())
                .build();
    }

    public TeacherDto build(Teacher teacher, List<SubjectDto> subjects, List<SchoolClassDto> classes) {
        return TeacherDto.builder()
                .id(teacher.getId())
                .name(teacher.getName())
                .surname(teacher.getSurname())
                .patronymic(teacher.getPatronymic())
                .description(teacher.getDescription())
                .subjects(ofNullable(subjects).orElse(emptyList()))
                .classes(ofNullable(classes).orElse(emptyList()))
                .build();
    }

}
