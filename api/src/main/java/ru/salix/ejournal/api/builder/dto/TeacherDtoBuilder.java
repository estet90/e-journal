package ru.salix.ejournal.api.builder.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.controller.dto.TeacherDto;
import ru.salix.ejournal.api.entity.Teacher;
import ru.salix.ejournal.api.mapper.TeacherMapper;

@Component
@RequiredArgsConstructor
public class TeacherDtoBuilder extends AbstractDtoBuilder<TeacherDto, Teacher> {

    private final TeacherMapper teacherMapper;

    @Override
    public TeacherDto build(Teacher teacher) {
        return teacherMapper.teacherToTeacherDto(teacher);
    }

}
