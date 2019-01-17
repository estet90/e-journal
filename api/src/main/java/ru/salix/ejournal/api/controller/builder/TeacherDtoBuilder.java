package ru.salix.ejournal.api.controller.builder;

import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.controller.dto.SchoolClassDto;
import ru.salix.ejournal.api.controller.dto.SubjectDto;
import ru.salix.ejournal.api.controller.dto.TeacherDto;
import ru.salix.ejournal.api.entity.Teacher;

import java.util.List;

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

}
